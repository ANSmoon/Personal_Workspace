package com.ssafy.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;


public class MyFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	public FilterConfig filterConfig;

	// filter 초기화 과정
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

	// filter 종료
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 서버에 가기전 필요한 코드 작성
		System.out.println("Servlet 전 1");

		// 다음 filter로 전달
		// 다음 filter가 없으면 servlet으로 전달
		String encoding = this.filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);

		chain.doFilter(request, response); // 다음 필터로 전달

		// 해당요청이 서블릿에 의해 처리 되어진 후 수행하고자 하는 코드
		////// 사용자에게 가기전 필요한 code 작성
		System.out.println("Servlet 후 1");
	}
}