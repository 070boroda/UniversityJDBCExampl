<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Students</title>
</head>
<body>

<h2>
<c:forEach items="${liststudents}" var="student">
 
  <td>${student.firstName}</td>
 
</c:forEach>

</h2>

</body>
</html>