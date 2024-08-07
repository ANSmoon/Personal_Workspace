package com.ssafy.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Interceptor는 HandlerInterceptor를 구현한 것!
public class BInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// boolean 형태의 반환 형태 => true 진행 / false 종료
		System.out.println("B : prehandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 정상 수행 후 실행, 예외 발생시 미실행
		System.out.println("B : posthandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// view가 전달된 후 실행 (무조건) 예외 미 발생시 객체는 null로 초기화
		System.out.println("B : aftercompletion");
	}
}