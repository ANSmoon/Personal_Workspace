<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 목록</h2>

	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>내용</th>
		</tr>

		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>${board.writer}</td>
				<td>${board.content}</td>
			</tr>
		</c:forEach>



	</table>


	<a href="write">게시글 등록</a>
</body>
</html>