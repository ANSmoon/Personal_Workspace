<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
<style>
#movie-list {
	border-collapse: collapse;
	width: 100%;
}

#movie-list td, #movie-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<h1>등록된 영화 목록</h1>
	<table id="movie-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>장르</th>
				<th>러닝타임</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 등록된 자료를 반복문을 이용해 출력한다. 테이블의 구성은 위 thead 참고 --%>
			<c:forEach items="${movies}" var="movie" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${movie.title}</td>
					<td>${movie.director}</td>
					<td>${movie.genre}</td>
					<td>${movie.runningTime}분</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>