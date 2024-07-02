<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="10_checkBoxResult.jsp">
		<input type="checkbox" name="food" value="한식">한식 <input
			type="checkbox" name="food" value="중식">중식 <input
			type="checkbox" name="food" value="일식">일식 <input
			type="checkbox" name="food" value="양식">양식 <input
			type="checkbox" name="food" value="패스트푸드">패스트푸드 <input
			type="checkbox" name="food" value="집밥">집밥
		<button>구매</button>
	</form>
</body>
</html>