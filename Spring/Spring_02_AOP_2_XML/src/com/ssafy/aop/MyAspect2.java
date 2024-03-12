package com.ssafy.aop;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class MyAspect2 {
	// method 명은 중요한게 아니다.
	public void before() {
		System.out.println("컴퓨터 부팅");
	}

	// 정상 수행 후
	public void afterReturning(int line) {
		System.out.println("Git에 push 한다 " + line + "개의 줄을 ....");
	}

	// 예외 발생
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	// 이후에
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}

	//////////////
	// around

	public int around(ProceedingJoinPoint pjt) {
		int line = 0;
		this.before();

		try {
			line = (int) pjt.proceed();
			this.afterReturning(line);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
		return line;
	}

}
