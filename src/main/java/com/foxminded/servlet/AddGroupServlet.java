package com.foxminded.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.dao.GroupDao;
import com.foxminded.dao.StudentDao;
import com.foxminded.entity.Student;

@WebServlet(name = "AddGroupServlet", urlPatterns = { "/AddGroupServlet" })
public class AddGroupServlet extends HttpServlet {
    StudentDao studentdao = new StudentDao();
    GroupDao groupdao = new GroupDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        try {
            switch (action == null ? "info" : action) {
            case "info":
            default:
                showList(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int idstudent = Integer.parseInt(request.getParameter("id"));
        int idgroup = Integer.parseInt(request.getParameter("groupid"));

        try {
            studentdao.updateGroupId(new Student(idgroup), idstudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("AddGroupServlet");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        request.setAttribute("liststudent", studentdao.getAll());
        request.setAttribute("listgroup", groupdao.getAll());
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/addstudenttogroup/addgroupmanager.jsp");
        dispatcher.forward(request, response);
    }

}
