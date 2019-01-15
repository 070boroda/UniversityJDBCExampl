<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule</title>
</head>
<body>
	<div align="center"> 
	 <h2>Schedule <c:out value="${day}"></c:out> group: 
	              <c:out value="${group.name}"></c:out><br>
	              <a href="ScheduleServlet?action=new&day=<c:out value='${day}'/>">Add One Field Lesson</a></h2>
	              	              
		<table border="1px">
			<tr>
				<th>Number Lesson</th>
				<th>Subject</th>				
			</tr>
			<c:forEach var="group" items="${listgroup}">
				<tr>
					<td><c:out value="${group.id}"></c:out>
					<td><c:out value="${group.name}"></c:out>
					<td><a
						href="ServletGroup?action=edit&id=<c:out value='${group.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="ServletGroup?action=delete&id=<c:out value='${group.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<%="index.jsp"%>">Go to start page</a>
	</div>


</body>
</html>