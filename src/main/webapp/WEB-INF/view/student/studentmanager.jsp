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
		<h1>Student Maneger</h1>
		<h2>
			<a href="ServletStudent?action=new">Add Student</a> <a href="/list">List Students</a>
		</h2>
	</center>
	<div align="center">
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Second Name</th>
			</tr>
			<c:forEach var="student" items="${liststudent}">
				<tr>
					<td><c:out value="${student.id}"></c:out>
					<td><c:out value="${student.firstName}"></c:out>
					<td><c:out value="${student.secondName}"></c:out>
					<td><a href="/edit?id=<c:out value='${student.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletStudent?action=delete&id=<c:out value='${student.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<%= "index.jsp" %>">Go to start page</a>
	</div>

</body>
</html>