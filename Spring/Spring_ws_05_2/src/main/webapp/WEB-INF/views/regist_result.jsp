<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<h1>영화 등록 결과</h1>
	<h2>등록된 영화 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>영화 제목</td>
				<td>${movie.title}</td>
				<td rowspan='5'>
					<c:if test="${movie.img ne null}">
						<img src="${pageContext.request.contextPath}/resources/upload/${movie.orgImg}">
					</c:if>
				</td>
			</tr>
			<tr>
				<td>감독</td>
				<td>${movie.director}</td>
			</tr>
			<tr>
				<td>장르</td>
				<td>${movie.genre}</td>
			</tr>
			<tr>
				<td>상영 시간</td>
				<td>${movie.runningTime}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="regist">추가 등록</a>
 		<a href="list">영화 목록</a>
	</div>

</body>
</html>
