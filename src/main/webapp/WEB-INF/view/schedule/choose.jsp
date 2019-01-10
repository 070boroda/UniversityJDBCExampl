<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Day and Groupe</title>
</head>
<body>
    <div align="center">
	<h1>Schedule</h1>
	<h2>Choose day and group</h2>
	<form action="ScheduleServlet" method="post">
	      Choose Groupe: <select id="id" name="groupid">
	      				 <option selected></option>
				         <c:forEach var="group" items="${grouplist}">
					     <option value="${group.id}">${group.name}</option>
				         </c:forEach>	
	                     </select>
						 
						 <select id="id" name="day">
						 <option selected></option>
				         <c:forEach var="day" items="${enumdayslist}">
					     <option value="${day}">${day}</option>
				         </c:forEach>
						 </select>
						 
						 <input type="submit" value="Submit">
	</form>	
	<a href="<%="index.jsp"%>">Back</a>
    </div>
</body>
</html>