<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="write" method="POST">
		<label for="writer">작성자</label>
		<input type="text" id="writer" name="writer" /><br/>
		
		<label for="content">내용</label>
		<textarea rows="10" cols="30" id="content" name="content"></textarea><br/>
		
		<button>등록</button>
	</form>
</body>
</html>