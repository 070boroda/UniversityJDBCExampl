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
     <ul>
        <a href="ServletStudent">students</a><br>
        <a href="ServletGroup">group</a><br>
        <a href="ServletSubject">subjects</a><br>
        <a href="ServletTeacher">teachers</a><br>
     </ul>
     
      <a href="<%= request.getRequestURI() %>">Try Again</a>
	</div>
</body>
</html>