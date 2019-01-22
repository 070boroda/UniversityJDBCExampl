<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>University</title>

</head>
<body>

      <div align="center">
      <h2>Simple Login Web Application using JSP/Servlet</h2>
     
        <a href="ServletStudent">Student</a><br>
        <a href="ServletGroup">Group</a><br>
        <a href="ServletSubject">Subjects</a><br>
        <a href="ServletTeacher">Teachers</a><br>
        <a href="ScheduleServlet">Schedule</a><br>
     
      <a href="<%= request.getRequestURI() %>">Try Again</a>
	</div>
</body>
</html>