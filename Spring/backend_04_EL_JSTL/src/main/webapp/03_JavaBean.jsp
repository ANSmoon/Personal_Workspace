<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.ssafy.dto.Person"%>
<%
Person p = new Person();
p.setName("Yujin");
p.setAge(20);
p.setHobbies(new String[] { "Sing", "Dance" });
pageContext.setAttribute("p", p);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean</title>
</head>
<body>
	<h2>JavaBeans</h2>
	<div>전체 정보 : ${p}</div>
	<div>이름 : ${p.name}</div>
	<div>나이 : ${p["age"]}</div>
	<div>취미 : ${p["hobbies"][1]}</div>
	<div>취미 : ${p["hobbies"][2]}</div>
</body>
</html>