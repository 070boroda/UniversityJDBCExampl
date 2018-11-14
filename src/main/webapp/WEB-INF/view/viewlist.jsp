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


<table border="1px">
 <tr>
     <th>First Name</th>
     <th>Second Name</th>
 </tr>

<c:forEach var="student" items="${liststudents}">
    <tr>
    <td><c:out value="${student.firstName}"/></td>
    <td><c:out value="${student.secondName}"/></td>
    </tr>
</c:forEach>

</table>



</body>
</html>