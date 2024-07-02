package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // bean으로 등록
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {}


	@Before("mypt()")
	// method 명은 중요한게 아니다.
	public void before() {
		System.out.println("컴퓨터 부팅");
	}

	@AfterReturning(value = "mypt()", returning = "line")
	// 정상 수행 후
	public void afterReturning(int line) {
		System.out.println("Git에 push 한다 " + line + "개의 줄을 ....");
	}

	@AfterThrowing(value = "mypt()", throwing = "th")
	// 예외 발생
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	@After("mypt()")
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
