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
		<h1>Add Student to Group</h1>
	</center>
	<div align="center">
		<form action="AddGroupServlet" method="post">
			<table border="1px">
				<tr>
					<th>First Name</th>
					<th>Second Name</th>
					<th>Group Name</th>
					<th>Change Group</th>
					<th>Group ID</th>
				</tr>
				<c:forEach var="student" items="${liststudent}">

					<tr>
						<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
						<td><c:out value="${student.firstName}"></c:out>
						<td><c:out value="${student.secondName}"></c:out> <c:forEach
								var="groupname" items="${listgroup}">
								<c:if test="${student.idgroup == groupname.id }">								
									
									<td><c:out value="${groupname.name}"></c:out>
								</c:if>
							</c:forEach>
						<td><select id="id" name="groupid">
								<option selected></option>
								<c:forEach var="group" items="${listgroup}">
									<option value="${group.id}">${group.name}</option>
								</c:forEach>
						</select></td>
					</tr>
				</c:forEach>
			</table>
			<a href="<%="index.jsp"%>">Go to start page</a>
			<p>
				<input type="submit" value="Submit">
			</p>
		</form>
	</div>
</body>
</html>
