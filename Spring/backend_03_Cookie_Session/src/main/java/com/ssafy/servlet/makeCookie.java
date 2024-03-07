package com.ssafy.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class makeCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		// cookie를 생성
		Cookie cookie = new Cookie(key, value);
		
		// 유효기간(만료단위) - sec
		cookie.setMaxAge(60); // 1분 유효기간 설정
		
		// 쿠키는 remove method가 따로 존재 X
//		cookie.setMaxAge(0); => cookie 삭제 방법
		
		// 사용자에게 전달
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath() + "/02_CookieResult.jsp");
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getCookies();
//		
//		for(Cookie c:) {
//			if(getName) {
//				
//			}
//		}
//	}
}
