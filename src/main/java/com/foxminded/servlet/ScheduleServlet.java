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

import com.foxminded.dao.GroupDao;
import com.foxminded.entity.DayOfWeek;
import com.foxminded.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {

    GroupDao groupdao = new GroupDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        try {
            switch (action == null ? "info" : action) {
            case "":
                break;
            default:
                log.info("show list from switch metod in servlet");
                showChooseList(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void showChooseList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        request.setAttribute("grouplist", groupdao.getAll());
        request.setAttribute("enumdayslist", DayOfWeek.values());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/schedule/choose.jsp");
        dispatcher.forward(request, response);
    }

}
