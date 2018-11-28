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
		<h1>Subject Manager</h1>
		<h2>
			<a href="ServletSubject?action=new">Add Subject</a>
		</h2>
	</center>
	<div align="center">
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<c:forEach var="subject" items="${listsubject}">
				<tr>
					<td><c:out value="${subject.id}"></c:out>
					<td><c:out value="${subject.name}"></c:out>
					<td><a
						href="ServletSubject?action=edit&id=<c:out value='${subject.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletSubject?action=delete&id=<c:out value='${subject.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<%="index.jsp"%>">Go to start page</a>
	</div>
</body>
</html>
