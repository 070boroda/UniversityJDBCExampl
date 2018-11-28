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
import com.foxminded.dao.SubjectDao;
import com.foxminded.entity.Group;
import com.foxminded.entity.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ServletSubject", urlPatterns = { "/ServletSubject" })
public class ServletSubject extends HttpServlet {
	SubjectDao subjectdao = new SubjectDao();

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
				deleteSubject(request, response);
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
				subjectdao.create(new Subject(name));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String name = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			try {
				System.out.println(id);
				subjectdao.update(new Subject(name), id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("ServletSubject");
	}

	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		List<Subject> list = null;
		list = subjectdao.getAll();
		request.setAttribute("listsubject", list);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/subject/subjectmanager.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		log.info("start deleteSubject in servlet" + this.getServletInfo());
		int id = Integer.parseInt(request.getParameter("id"));
		Subject subject = new Subject(id);
		subjectdao.delete(subject);
		response.sendRedirect("ServletSubject");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/subject/subjectform.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Subject subject = subjectdao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/subject/subjectform.jsp");
		request.setAttribute("subject", subject);
		dispatcher.forward(request, response);
	}
}
