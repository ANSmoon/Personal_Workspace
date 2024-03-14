<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Interceptor</h2>
	<c:choose>
		<c:when test="${empty id}">
			<div>
				<a href="login">Login page</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				${id}님 hi. <a href="logout"> Logout</a>
			</div>
		</c:otherwise>

	</c:choose>
	<div>
		<a href="regist1"> 게시글 등록</a>
	</div>
</body>
</html>