package com.multicampus.web.common;

import java.io.IOException;

import com.multicampus.biz.user.UserVO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/getBoardList.do", 
		                  "/getBoard.do", 
		                  "/deleteBoard.do"})
public class AuthenticationFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

//	public AuthenticationFilter() {
//        System.out.println("===> AuthenticationFilter 생성");
//    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 세션에 "user"라는 이름으로 등록된 정보가 있는지 확인한다.
		HttpSession session = req.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) {
			res.sendRedirect("/");
		} else {		
			chain.doFilter(req, res);
		}
	}

}






