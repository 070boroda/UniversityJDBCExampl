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

     <h2>Simple Login Web Application using JSP/Servlet</h2>
      
     <ul>
        <li><a href="ServletStudent">students</a></li>
        <li><a href="subjects">subjects</a></li>
        <li><a href="teachers">teachers</a>
     </ul>
     
      <a href="<%= request.getRequestURI() %>">Try Again</a>

</body>
</html>