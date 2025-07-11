<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp" %>

<center>
<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="500">
	<tr>
		<td bgcolor="orange" width="100">제목</td>
		<td><input name="title" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td><input name="writer" type="text" size="20"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td><textarea name="content" rows="10" cols="40"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록"/>
			<input type="reset" value="모두 지우기"/>
		</td>
	</tr>
</table>
</form>
</center>

<%@include file="../layout/footer.jsp" %>









