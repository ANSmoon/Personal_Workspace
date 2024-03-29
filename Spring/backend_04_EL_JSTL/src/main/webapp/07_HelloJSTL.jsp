<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h3>C:out</h3>
	<c:out value = "Hello JSTL3"></c:out><br>
	<c:out value = "Hello JSTL4"></c:out><br>
	
	<hr>
	<h3>C:set</h3>
	<c:set var = "name1" value = "Mun"/> ${name1} <br>
	<c:set var = "name2">Jang</c:set> ${name2} <br>
	
	<!-- person이라는 변수에 생성자를 호출해 버린다. -->
	<c:set var = "person" value = "<%= new com.ssafy.dto.Person() %>"/>
	<c:set target="${person}" property="name" value ="An"/>
	${person }<br>
	
</body>
</html>