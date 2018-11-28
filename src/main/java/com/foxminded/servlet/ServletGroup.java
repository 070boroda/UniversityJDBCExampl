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
import com.foxminded.entity.Group;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ServletGroup", urlPatterns = { "/ServletGroup" })
public class ServletGroup extends HttpServlet {
    GroupDao groupdao = new GroupDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            switch (action == null ? "info" : action) {
            case "new":
                log.info("new servlet");
                showNewForm(request, response);
                break;
            case "delete":
                log.info("switch /delete");
                deleteGroup(request, response);
                break;
            case "edit":
                log.info("switch edit");
                showEditForm(request, response);
                break;
            case "info":
            default:
                log.info("show list from switch metod in servlet");
                showList(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            String name = request.getParameter("name");

            try {
                groupdao.create(new Group(name));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {

            String name = request.getParameter("name");            
            Integer id = Integer.parseInt(request.getParameter("id"));
            try {
            	System.out.println(id);
                groupdao.update(new Group(name), id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("ServletGroup");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        List<Group> list = null;
        list = groupdao.getAll();
        request.setAttribute("listgroup", list);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/group/groupmanager.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteGroup(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        log.info("start deleteStudent in servlet" + this.getServletInfo());
        int id = Integer.parseInt(request.getParameter("id"));
        Group group = new Group(id);
        groupdao.delete(group);
        response.sendRedirect("ServletGroup");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/group/formgroup.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Group group = groupdao.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/group/formgroup.jsp");
        request.setAttribute("group", group);
        dispatcher.forward(request, response);
    }
}
