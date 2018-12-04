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
import com.foxminded.dao.StudentDao;
import com.foxminded.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "ServletStudent", urlPatterns = { "/ServletStudent" })
public class ServletStudent extends HttpServlet {
	StudentDao studentdao = new StudentDao();
	GroupDao groupdao = new GroupDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType ("text/html; charset=UTF-8");
		request.setCharacterEncoding ("UTF-8");
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
		response.setContentType ("text/html; charset=UTF-8");
		request.setCharacterEncoding ("UTF-8");
		if (request.getParameter("id") == null) {
			String firstname = request.getParameter("firstname");
			String secondname = request.getParameter("secondname");
			Integer groupid = Integer.parseInt(request.getParameter("groupid"));
			try {
				studentdao.create(new Student(firstname, secondname,groupid));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String firstname = request.getParameter("firstname");
			String secondname = request.getParameter("secondname");
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer groupid = Integer.parseInt(request.getParameter("groupid"));
			try {
				studentdao.update(new Student(firstname, secondname, groupid), id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("ServletStudent");
	}

	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		List<Student> liststudent = null;
		liststudent = studentdao.getAll();
		request.setAttribute("liststudent", liststudent);
		request.setAttribute("listgroup", groupdao.getAll());
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/view/student/studentmanager.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		log.info("start deleteStudent in servlet" + this.getServletInfo());
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = new Student(id);
		studentdao.delete(student);
		response.sendRedirect("ServletStudent");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/formstudent.jsp");
		try {
			request.setAttribute("grouplist", groupdao.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentdao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/formstudent.jsp");
		request.setAttribute("student", student);
		request.setAttribute("grouplist", groupdao.getAll());
		dispatcher.forward(request, response);
	}
}
