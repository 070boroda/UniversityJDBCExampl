<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
</head>
<body>
	<centre>
	<h2>
	<c:if test="${student != null}">
          Edit Student
    </c:if>
	<c:if test="${student == null}">
           Add Student
    </c:if>
	</h2>
	<form action="ServletStudent" method="post">
		First Name :<input type="text" name="firstname"><br>
		Second Name :<input type="text" name="secondname"><br> <input
			type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>
