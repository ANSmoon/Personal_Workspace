<%@page import="java.util.Date"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예외 발생</title>
</head>
<body>
<center>
<h1>발생된 예외 : <%= exception.getClass().getName() %></h1>
<hr>
<%
	StackTraceElement[] elements = exception.getStackTrace();
%>
<%
	Date currentDate = new Date();
%>
예외 발생 시간 : <%= currentDate.toString() %><br>
발생된 예외의 위치 : <%= elements[0].toString() %>
</center>
</body>
</html>





