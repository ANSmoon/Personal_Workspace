<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div>
	<!-- 로그인 안했을 때 -->
	<c:if test="${empty loginUser}">
		<a href="login" class="btn btn-outline-warning">LogIn</a>
		<a href="signup" class="btn btn-outline-primary">SingUp</a>
	</c:if>

	<!-- 로그인 했을 때 -->
	<c:if test="${not empty loginUser}">
		<span>${loginUser}님 반갑습니다.</span>
		<a href="logout" class="btn btn-outline-danger">LogOut</a>
		<c:if test="${'admin' eq loginUser }">
			<a href="users">관리자페이지</a>
		</c:if>
	</c:if>
</div>