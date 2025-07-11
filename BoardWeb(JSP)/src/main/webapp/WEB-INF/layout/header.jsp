<%@page import="com.multicampus.biz.user.UserVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page errorPage="errors/boardError.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 프로그램</title>
</head>

<body>
<hr>
<a href="/">HOME</a>&nbsp;&nbsp;&nbsp;

<%
	// 세션에 "user"라는 이름으로 등록된 회원 정보가 있는지 확인한다.
	UserVO user = (UserVO) session.getAttribute("user");
%>

<c:if test="${user == null }">
<a href="insertUserView.do">회원가입</a>&nbsp;&nbsp;&nbsp;
<a href="loginView.do">로그인</a>&nbsp;&nbsp;&nbsp;
</c:if>

<c:if test="${user != null }">
<a href="insertBoardView.do">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;
<a href="logout.do">로그아웃</a>&nbsp;&nbsp;&nbsp;
</c:if>

<hr>

<br><br>








