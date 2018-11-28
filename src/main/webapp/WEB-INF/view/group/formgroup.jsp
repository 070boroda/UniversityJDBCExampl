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
	<c:if test="${group != null}">
          Edit Group
    </c:if>
	<c:if test="${group == null}">
           Add Group
    </c:if>
	</h2>
	<form action="ServletGroup" method="post">
	<c:if test="${group != null}">
	<input type="hidden" name="id" value="<c:out value='${group.id}' />" />
	</c:if> 
		Name :<input type="text" name="name"   value="<c:out value='${group.name}' />" /><br>
		<input type="submit" value="Submit">
	</form>
	</centre>
</body>
</html>
