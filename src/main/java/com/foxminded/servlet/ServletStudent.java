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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ServletStudent", urlPatterns = { "/ServletStudent" })
public class ServletStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletStudent() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
            case "/new":
                addStudent(request, response);
                break;
            case "/delete":
                log.info(" switch /delete");
                deleteStudent(request, response);
                break;
            case "/edit":
                editStudent(request, response);
                break;
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
        doGet(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        StudentDao studentdao = new StudentDao();
        List<Student> list = null;
        list = studentdao.getAll();
        request.setAttribute("liststudent", list);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/student/studentmanager.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        log.info("start deleteStudent in servlet" + this.getServletInfo());
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDao studentdao = new StudentDao();
        Student student = new Student(id);
        studentdao.delete(student);
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    }

}
