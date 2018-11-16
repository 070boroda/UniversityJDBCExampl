package com.foxminded.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxminded.dao.StudentDao;
import com.foxminded.entity.Student;

@WebServlet(name = "ServletStudent", urlPatterns = { "/ServletStudent" })
public class ServletStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletStudent() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDao studentdao = new StudentDao();
        List<Student> list = null;

        try {
            list = studentdao.getAll();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/viewDBpeople.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
