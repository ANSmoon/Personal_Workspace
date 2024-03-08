<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% out.print("Hello World by script"); %> <!-- scripting -->
	<%= "Hello Wrold! by expression" %> <!-- Expression -->
	${"Hello World! by EL" }; <!-- Expression Languege -->
</body>
</html>