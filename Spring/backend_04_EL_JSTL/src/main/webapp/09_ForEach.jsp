<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
	String[] dramaList = { "아이언맨", "오징어게임", "귀멸의칼날", "소년시대" };
	pageContext.setAttribute("drama", dramaList);
	%>

	<h3>C:forEach</h3>

	<c:forEach items="${drama}" var="dra">
		<ul>
			<li>${dra}</li>
		</ul>
	</c:forEach>

	<hr>

	<c:forEach var="dra" items="${drama}" varStatus="status" begin="1"
		end="3" step="2">
		<div>${status.index}: ${dra} index</div>
		<br>
	</c:forEach>

	<hr>

	<c:forEach var="drama" items="${drama}" varStatus="status" begin="1"
		end="3" step="2">
		<div>${status.count}: ${drama} count</div>
		<br>
	</c:forEach>
</body>
</html>