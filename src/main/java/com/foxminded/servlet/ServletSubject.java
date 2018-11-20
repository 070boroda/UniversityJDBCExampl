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

import com.foxminded.dao.SubjectDao;
import com.foxminded.entity.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/ServletSubject")
public class ServletSubject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> list = null;

        try {
            log.info("Start querie in servlet " + this.getServletInfo());
            list = subjectDao.getAll();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/viewDBgroupandsubject.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
