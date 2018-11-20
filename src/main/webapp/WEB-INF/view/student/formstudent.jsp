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
	<h1>Add Student</h1>
	<form action="ServletStudent" method="post">
		First Name :<input type="text" name="firstname"><br>
		Second Name :<input type="text" name="secondname"><br> <input
			type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>