<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operator</title>
</head>
<body>
	\${5+2} : ${5+2}<br>
	\${5/2} : ${5/2}<br>
	<%-- \${5 div 2} : ${5 div 2}<br> --%> <!-- 형식상 문제는 없는데 그냥 빨간색 뜸 -->
	\${5 gt 2} : ${5 gt 2}<br>
	\${5 < 2} : ${5 < 2}<br>

</body>
</html>