<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
	<center>
		<h1>Teacher Manager</h1>
		<h2>
			<a href="ServletTeacher?action=new">Add Teacher</a>
		</h2>
	</center>
	<div align="center">
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Second Name</th>
			</tr>
			<c:forEach var="teacher" items="${listteacher}">
				<tr>
					<td><c:out value="${teacher.id}"></c:out>
					<td><c:out value="${teacher.firstName}"></c:out>
					<td><c:out value="${teacher.secondName}"></c:out>
					<td><a
						href="ServletTeacher?action=edit&id=<c:out value='${teacher.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletTeacher?action=delete&id=<c:out value='${teacher.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<%="index.jsp"%>">Go to start page</a>
	</div>
</body>
</html>
