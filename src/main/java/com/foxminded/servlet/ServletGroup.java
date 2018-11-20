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
@WebServlet("/ServletGroup")
public class ServletGroup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GroupDao groupdao = new GroupDao();
        List<Group> list = null;
        try {
            log.info("Start querie in servlet " + this.getServletInfo());
            list = groupdao.getAll();
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
