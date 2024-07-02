<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른 JSP include</title>
</head>
<body>
	<%@ include file="/template/header.jsp"%>
	<!-- include를 통해 header와 footer를 가져올 수 있다. -->
	<h2>Main 내용임다.</h2>
</body>
</html>