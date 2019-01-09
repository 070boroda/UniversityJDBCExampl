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
		<c:if test="${student != null}">
			<input type="hidden" name="id"
				value="<c:out value='${student.id}' />" />
		</c:if>
		    First Name :<input type="text" name="firstname"
			value="<c:out value='${student.firstName}' />" /><br> 
			Second Name :<input type="text" name="secondname"
			value="<c:out value='${student.secondName}' />" /><br>
		        <td><select id="id" name="groupid">
				    <option selected></option>
				    <c:forEach var="group" items="${grouplist}">
					<option value="${group.id}">${group.name}</option>
				</c:forEach>
		            </select></td> <input type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>
