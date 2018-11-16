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
import com.foxminded.dao.TeacherDao;
import com.foxminded.entity.Teacher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/ServletTeacher")
public class ServletTeacher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDao teacher = new TeacherDao();
        List<Teacher> list = null;

        try {
            log.info("Start querie in servlet " + this.getServletInfo());
            list = teacher.getAll();
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
