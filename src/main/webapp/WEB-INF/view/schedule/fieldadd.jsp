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
			Day: <input type=text name="day" value="<c:out value='${day}'/>" />
			<br> Group: <input type=text name="group"
				value="<c:out value='${group}'/>" /> <br> Number Lesson : <select
				id="id" name="numberlesson">
				<option selected></option>
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
			</select><br> Subject: <select id="id" name="subject">
				<option selected></option>
				<c:forEach var="subject" items="${subjectlist}">
					<option value="${subject.id}">${subject.name}</option>
				</c:forEach>
			</select><br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>
