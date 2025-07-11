<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp" %>

<!-- lang이라는 파라미터를 통해 전달된 Locale을 추출하여 세션에 등록하고 세션에 종료될 때까지 해당 언어를 유지한다. -->
<fmt:setLocale value="${param.lang }" scope="session"/>

<fmt:bundle basename="messages.messageSource">

<center>
<form action="login.do" method="post">
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td bgcolor="orange"><fmt:message key="user.login.id"/></td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td bgcolor="orange"><fmt:message key="user.login.password"/></td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="<fmt:message key="user.login.login_btn"/>"/>
			</td>
		</tr>
	</table>
</form>	
<a href="loginView.do?lang=en"><fmt:message key="user.login.language.en"/></a>&nbsp;&nbsp;&nbsp;
<a href="loginView.do?lang=ko"><fmt:message key="user.login.language.ko"/></a>
</center>
</fmt:bundle>

<%@include file="../layout/footer.jsp" %>






