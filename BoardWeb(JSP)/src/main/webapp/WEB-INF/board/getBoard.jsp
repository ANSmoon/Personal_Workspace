<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp" %>
<!-- 
	EL(Expression Language)
	JSP 내장객체(request, session, application)에 등록된 데이터에 접근하기 위한 표현 언어
	
	JSTL(JSP Standard Tag Library)
	JSP 파일에서 if, for, switch 등과 같은 JAVA 코드를 대체하기 위해 제공되는 표준 태그
 -->

<center>
<font color="skyblue">${sessionScope.user.name}</font>님 안뇽하세요.
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0" width="500">
	<tr>
		<td bgcolor="orange" width="100">제목</td>
		<td><input name="title" type="text" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td><textarea name="content" rows="10" cols="40">${board.content }</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td>${board.regDate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td>${board.cnt }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="전송버튼"/>
			<input type="reset" value="취소버튼"/>
		</td>
	</tr>
</table>
</form>
<br>

<%-- <%
	if(user.getRole().equals("ADMIN")) {
%> --%>
<c:if test="${user.role=='ADMIN' }">
<a href="deleteBoard.do?seq=${board.seq }">게시글 삭제</a>
</c:if>
<%-- <%
	}
%> --%>
</center>

<%@include file="../layout/footer.jsp" %>