<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Group</title>
</head>
<body>
	<centre>
	<h2>
		<c:if test="${subject != null}">
          Edit Subject
    </c:if>
		<c:if test="${subject == null}">
           Add Subject
    </c:if>
	</h2>
	<form action="ServletSubject" method="post">
		<c:if test="${subject != null}">
			<input type="hidden" name="id" value="<c:out value='${subject.id}' />" />
		</c:if>
		Name :<input type="text" name="name"
			value="<c:out value='${subject.name}' />" /><br> <input
			type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>
