<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TITLE</title>
</head>
<body>
	<center>
	<h1>EL 테스트</h1>
	
	<hr>
	정수 : ${35} <br> <br>
	실수 : ${35.0315} <br> <br>
	문자열 : ${"ANSMOON"} <br> <br>
	+ 연산 : ${777 + 5642} <br> <br>
	% 연산 : ${100 % 27} <br> <br>
	비교연산 : ${100 == 120} <br> <br>
	비교연산2 : ${1 == 1} <br> <br>
	비교연산3 : ${35 >= 21} <br> <br>
	아이디 : <%= request.getParameter("id") %> <br> <br>
	아이디 : ${param.id } <br> <br>

	</center>
</body>
</html>