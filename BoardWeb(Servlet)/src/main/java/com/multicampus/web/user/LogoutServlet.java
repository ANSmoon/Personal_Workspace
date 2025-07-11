package com.multicampus.web.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> 로그아웃 처리");

		// 로그아웃을 요청한 브라우저와 매핑된 세션을 강제로 종료한다.
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 화면 이동
		response.sendRedirect("/");
    }   
}