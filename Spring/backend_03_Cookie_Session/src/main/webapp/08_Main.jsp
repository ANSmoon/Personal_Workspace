<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
	if (session.getAttribute("id") == null) {
		response.sendRedirect("07_LoginForm.jsp");
	} else {
	%>
	<!--  -->
	<%=session.getAttribute("id")%>
	<%
	}
	%>

	<hr>
	<h2>Main page</h2>

	<!-- Logout -->
	<a href="07_Logout.jsp">Logout</a>
	<form action="07_Logout" method="POST">
		<input type="submit">
		<button>Logout</button>
	</form>

	<%-- <%=session.getAttribute("id")%> --%>
	<%-- <%=request.getParameter("password") %> --%>

</body>
</html>