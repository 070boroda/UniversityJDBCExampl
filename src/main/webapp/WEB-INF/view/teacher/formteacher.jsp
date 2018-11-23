<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Teacher</title>
</head>
<body>
	<centre>
	<h2>
	<c:if test="${teacher != null}">
          Edit Teacher
    </c:if>
	<c:if test="${teacher == null}">
           Add Teacher
    </c:if>
	</h2>
	<form action="ServletTeacher" method="post">
	<c:if test="${teacher != null}">
	<input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
	</c:if> 
		First Name :<input type="text" name="firstname"   value="<c:out value='${teacher.firstName}' />" /><br>
		Second Name :<input type="text" name="secondname" value="<c:out value='${teacher.secondName}' />" /><br> 
		<input type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>
