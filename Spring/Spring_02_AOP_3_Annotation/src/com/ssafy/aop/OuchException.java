package com.ssafy.aop;

public class OuchException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	// 예외 객체로 만들기

	public void handleException() {
		System.out.println("비상!");
	}
	
}
