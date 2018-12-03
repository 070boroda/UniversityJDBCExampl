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
import com.foxminded.entity.Group;
import com.foxminded.entity.Student;

@WebServlet(name = "AddGroupServlet", urlPatterns = {"/AddGroupServlet"})
public class AddGroupServlet extends HttpServlet {
	StudentDao studentdao = new StudentDao();
	GroupDao groupdao = new GroupDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		response.setContentType ("text/html; charset=UTF-8");
		request.setCharacterEncoding ("UTF-8");
		try {
			showList(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html; charset=UTF-8");
		request.setCharacterEncoding ("UTF-8");
	}

	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {				
		request.setAttribute("liststudent", studentdao.getAll());
		request.setAttribute("listgroup", groupdao.getAll());
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/view/addstudenttogroup/addgroupmanager.jsp");
		dispatcher.forward(request, response);
	}
	
}
