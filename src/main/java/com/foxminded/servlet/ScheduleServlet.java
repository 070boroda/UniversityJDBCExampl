package com.foxminded.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
import com.foxminded.entity.Field;
import com.foxminded.entity.Group;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ScheduleServlet", urlPatterns = { "/ScheduleServlet" })
public class ScheduleServlet extends HttpServlet {

    private SubjectDao subjectdao = new SubjectDao();
    private FieldDao fieldDao = new FieldDao();
    private GroupDao groupDao = new GroupDao();
    private SubjectDao subjectDao = new SubjectDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        try {
            switch (action == null ? "info" : action) {
            case "new":
                log.info("new servlet " + getServletName());
                showNewForm(request, response);
                break;
            case "delete":
                log.info("delete servlet " + getServletName());
                deleteField(request, response);
                break;
            default:
                log.info("show list from switch metod in servlet");
                showChooseList(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
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

            log.info("start add serv");
            String day = request.getParameter("day");
            log.info("after day " + day);
            Integer numberlesson = Integer.parseInt(request.getParameter("numberlesson"));
            log.info("numberlesson " + numberlesson);
            Integer subjectid = Integer.parseInt(request.getParameter("subject"));
            log.info("subject id " + subjectid);
            String groupname = request.getParameter("group");
            log.info("groupname " + groupname);
            try {
                Group group = groupDao.getByName(groupname);
                Integer groupid = group.getId();
                log.info("daogetID " + groupid);
                fieldDao.create(new Field(numberlesson, day, subjectid, groupid));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("ScheduleServlet");
        }
    }

    private void showChooseList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        request.setAttribute("grouplist", groupDao.getAll());

        request.setAttribute("enumdayslist", DayOfWeek.values());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/schedule/choose.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("day", request.getParameter("day"));
        request.setAttribute("group", request.getParameter("group"));
        try {
            request.setAttribute("grouplist", groupDao.getAll());
            request.setAttribute("subjectlist", subjectdao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/schedule/fieldadd.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteField(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        log.info("start deleteField in servlet" + getServletName());
        int id = Integer.parseInt(request.getParameter("id"));
        Field field = new Field(id);
        fieldDao.delete(field);
        response.sendRedirect("ScheduleServlet");
    }
}
