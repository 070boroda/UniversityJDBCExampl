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
	         
	</div>

</body>
</html>