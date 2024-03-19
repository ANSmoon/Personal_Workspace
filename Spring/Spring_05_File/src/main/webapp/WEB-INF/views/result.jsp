<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Single File Upload</title>
</head>
<body>
	<h2>Single File Upload</h2>
	<a href="${pageContext.request.contextPath}/resources/upload/${fileName}">${fileName}</a>
	<img src="${pageContext.request.contextPath}/resources/upload/${fileName}">
	
	<a href="download?fileName=${fileName}">${fileName} Download</a>
</body>
</html>