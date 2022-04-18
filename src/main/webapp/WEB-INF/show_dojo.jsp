<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
	<a href="/ninja">add ninja</a>
	<a href="/dojo">add dojo</a>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
			<c:forEach items="${dojo.ninjas}" var="i">
			<tr>
				<td>${i.firstName}</td>
				<td>${i.lastName}</td>
				<td>${i.age}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>