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
	<h1>New Ninja</h1>
	<form:form action="/create_ninja" method="POST" modelAttribute="ninja">
		<form:label path="dojo">Dojo:</form:label>
		<form:select path="dojo">
		<c:forEach items="${dojo}" var="d">
			<form:option value="${d.id}">${d.name}</form:option>
		</c:forEach>
		</form:select>
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" />
		<form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" />
		<form:label path="age">Age:</form:label>
		<form:input type="number" path="age" />
		<form:errors path="age" />
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>