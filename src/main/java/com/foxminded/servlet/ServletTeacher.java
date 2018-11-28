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
@WebServlet(name = "ServletTeacher", urlPatterns = { "/ServletTeacher" })
public class ServletTeacher extends HttpServlet {
	TeacherDao teacherdao = new TeacherDao();

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
				deleteStudent(request, response);
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
		if (request.getParameter("id") == null) {
			String firstname = request.getParameter("firstname");
			String secondname = request.getParameter("secondname");

			try {
				teacherdao.create(new Teacher(firstname, secondname));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String firstname = request.getParameter("firstname");
			String secondname = request.getParameter("secondname");
			Integer id = Integer.parseInt(request.getParameter("id"));
			try {
				teacherdao.update(new Teacher(firstname, secondname), id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("ServletTeacher");
	}

	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		List<Teacher> list = null;
		list = teacherdao.getAll();
		request.setAttribute("listteacher", list);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/view/teacher/teachermanager.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		log.info("start deleteStudent in servlet" + this.getServletInfo());
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = new Teacher(id);
		teacherdao.delete(teacher);
		response.sendRedirect("ServletTeacher");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacher/formteacher.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = teacherdao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/teacher/formteacher.jsp");
		request.setAttribute("teacher", teacher);
		dispatcher.forward(request, response);
	}
}
