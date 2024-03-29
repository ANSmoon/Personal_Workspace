<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
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
	<h1>영화 등록 결과</h1>
	<h2>지금까지 등록한 영화 수 : ${movieCount}</h2>
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
				<td>제목</td>
				<td><%=request.getParameter("title")%>
			</tr>

			<tr>
				<td>감독</td>
				<td><%=request.getParameter("director")%>
			</tr>


			<tr>
				<td>장르르</td>
				<td><%=request.getParameter("genre")%>
			</tr>


			<tr>
				<td>상영시간</td>
				<td><%=request.getParameter("runningTime")%>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="regist.jsp">추가등록</a>
		<form method="post" action="main">
			<input type="hidden" name="action" value="list"> <input
				type="submit" value="영화목록">
		</form>
	</div>
</body>
</html>