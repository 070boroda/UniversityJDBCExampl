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
	<form action="AddGroupServlet" metod = "post">
	
	<div align="center">
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Second Name</th>
				<th>Group Name</th>
			</tr>
			<c:forEach var="student" items="${liststudent}">
						
				<tr>
					<td><c:out value="${student.id}"></c:out>
			        <td><c:out value="${student.firstName}"></c:out>
					<td><c:out value="${student.secondName}"></c:out>
					<c:if test="${student.idgroup == 0 }">                  
					<td><select>
					   
                        <c:forEach var="group" items="${listgroup}">
                        <option>
                                <c:out value="${group.name}"></c:out>
                        </option>
                        </c:forEach>                                             					       					
					   </select>						
					</td>
					</c:if> 					
				</tr>
				</c:forEach>
		</table>
		<a href="<%="index.jsp"%>">Go to start page</a>
		<p><input type="submit" value="Submit"></p>
	</div>
	</form>
</body>
</html>
