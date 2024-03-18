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
	<form action="singleFileUpload" method = "POST" enctype = "multipart/form-data">		
		<input type  ="file" name = "file">
		<input type = "submit" value = "파일 등록">
	</form>
</body>
</html>