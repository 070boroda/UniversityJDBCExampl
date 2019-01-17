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
		<h2>Add field of schedule</h2>

		<form action="ScheduleServlet?action=add" method="post">
		Day:
		<c:out value='${day}'></c:out>
		<br> Group:
		<c:out value="${group}"></c:out>
		<br> Number Lesson :
		<select id="id" name="numberlesson">
				<option selected></option>
				<option value=numberlesson>1</option>
				<option value=numberlesson>2</option>
				<option value=numberlesson>3</option>
				<option value=numberlesson>4</option>
		</select><br> Subject:
		<select id="id" name="subject">
				<option selected></option>
				<c:forEach var="subject" items="${subjectlist}">
					<option value="${subject.id}">${subject.name}</option>
				</c:forEach>
		</select><br>
		<input type="submit" value="Submit">
    </form>
	</div>
</body>
</html>
