<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List from DB</title>
</head>
<body>

<table border="1px">
 <tr>
     <th>Second Name</th>
 </tr>

<c:forEach var="value" items="${list}">
    <tr>
    <td><c:out value="${value.name}"/></td>
    </tr>
</c:forEach>
<h2>
<a href="<%= "index.jsp" %>">Go to start page</a>
</h2>
</table>
</body>
</html>
