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

import com.foxminded.dao.FieldDao;
import com.foxminded.dao.GroupDao;
import com.foxminded.dao.SubjectDao;
import com.foxminded.entity.DayOfWeek;
import com.foxminded.entity.NumberLesson;
import com.foxminded.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ScheduleServlet", urlPatterns = { "/ScheduleServlet" })
public class ScheduleServlet extends HttpServlet {

    GroupDao groupdao = new GroupDao();
    SubjectDao subjectdao = new SubjectDao();
    FieldDao fieldDao = new FieldDao();
    GroupDao groupDao = new GroupDao();
    SubjectDao subjectDao = new SubjectDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = (String) request.getParameter("action");
        System.out.println(action);
        switch (action == null ? "info" : action) {
        case "new":
            log.info("new servlet");
            showNewForm(request, response);
            break;
        default:
            log.info("show list from switch metod in servlet");
            try {
                showChooseList(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("choose".equals(action)) {
            String day = request.getParameter("day");
            Integer groupid = Integer.parseInt(request.getParameter("groupid"));

            try {
                request.setAttribute("fieldlist", fieldDao.getAllByDayAndGroup(day, groupid));
                request.setAttribute("group", groupDao.getById(groupid));
                request.setAttribute("subjectlist", subjectDao.getAll());
                request.setAttribute("day", day);
            } catch (SQLException e) {
                log.info("getAllPost" + getServletName());
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/view/schedule/fieldmanager.jsp");
            dispatcher.forward(request, response);
        } else if ("add".equals(action)) {

        }
    }

    private void showChooseList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        request.setAttribute("grouplist", groupdao.getAll());

        request.setAttribute("enumdayslist", DayOfWeek.values());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/schedule/choose.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("day", request.getParameter("day"));
        request.setAttribute("group", request.getParameter("group"));
        try {
            request.setAttribute("grouplist", groupdao.getAll());
            request.setAttribute("subjectlist", subjectdao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/schedule/fieldadd.jsp");
        dispatcher.forward(request, response);
    }
}
