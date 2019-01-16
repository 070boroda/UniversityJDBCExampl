<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Field</title>
</head>
<body>
	<div align="center">
	<h2>Add field of schedule <c:out value='${day}'></c:out></h2>
							  <c:out value="${group.name}"></c:out>		
	<form action="ScheduleServlet?action=add" method="post"></form>	
	
	        Number Lesson :<input type="text" name="numberLesson"
			value="<c:out value='' />" /><br> 
			Subject :<input type="text" name="subject"
			value="<c:out value='' />" /><br>
		        <td><select id="id" name="groupid">
				    <option selected></option>
				<c:forEach var="group" items="${grouplist}">
					<option value="${group.id}">${group.name}</option>
				</c:forEach>
		            </select></td> <input type="submit" value="Submit">
	
	
	</div>

</body>
</html>