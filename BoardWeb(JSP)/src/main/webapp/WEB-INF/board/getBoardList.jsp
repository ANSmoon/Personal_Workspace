<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp"%>

<center>
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="get">
		<table border="1" cellpadding="0" cellspacing="0" width="800">
			<tr>
				<td align="right"><select name="condition">
						<option value="title" ><c:if
								test="${condition=='title'}"></c:if>제목
						<option value="content" ><c:if
								test="${condition=='content' }"></c:if>내용
				</select> <input name="keyword" type="text" value="${keyword }" /> <input
					type="submit" value="검색" /></td>
			</tr>
			</form>
			<!-- 검색 종료 -->

			<table border="1" cellpadding="0" cellspacing="0" width="800">
				<tr>
					<th bgcolor="orange" width="100">번호</th>
					<th bgcolor="orange" width="400">제목</th>
					<th bgcolor="orange" width="100">작성자</th>
					<th bgcolor="orange" width="100">등록일</th>
					<th bgcolor="orange" width="100">조회수</th>
				</tr>

				<c:forEach var="board" items="${requestScope.boardList }">
					<tr>
						<td>${board.seq }</td>
						<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
						<td>${board.writer }</td>
						<td>${board.regDate }</td>
						<td>${board.cnt }</td>
					</tr>
				</c:forEach>

			</table>
			</center>

			<%@include file="../layout/footer.jsp"%>