<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%!int x = 10;
	int y = -20;

	String name = "SSAFY";

	public int add(int x, int y) {
		return x + y;
	}

	public int abs(int x) {
		return x > 0 ? x : -x;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>
</head>
<body>
<%= name %><br>
<%= add(x,y) %><br>
<%= abs(y) %><br>

	<a href="index.html">홈으로</a>
</body>
</html>