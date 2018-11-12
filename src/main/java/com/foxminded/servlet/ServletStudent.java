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

@WebServlet("/ServletStudent")
public class ServletStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentDao studentdao = new StudentDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> list = null;
        try {
            list = studentdao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("liststudents", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/viewList.jsp\"");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
