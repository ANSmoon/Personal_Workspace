package com.multicampus.web.common;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.do", 
           initParams = @WebInitParam(name = "Author", value = "ANSMOON"))
public class TimeCheckFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	private String author;

//	public TimeCheckFilter() {
//        System.out.println("===> TimeCheckFilter 생성");
//    }
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		author = config.getInitParameter("Author");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 작성자 : " + author);
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		long startTime = System.currentTimeMillis();
		
		// 이 순간 브라우저가 요청한 서블릿이 실행된다.
		chain.doFilter(request, response);	
		
		long endTime = System.currentTimeMillis();
		System.out.println(uri + " 요청 처리에 소요된 시간 : " + (endTime - startTime) + "(ms)초");
		
	}

}






