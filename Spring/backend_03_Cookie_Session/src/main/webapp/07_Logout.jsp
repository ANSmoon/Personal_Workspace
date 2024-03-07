<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<!-- Logout -->

	<%-- <%session.removeAttribute("id"); %> --%>

	<%
	session.invalidate();
	%>

	<script>
		alert("logout 완료")
		location.href = "index.html";
	</script>

</body>
</html>