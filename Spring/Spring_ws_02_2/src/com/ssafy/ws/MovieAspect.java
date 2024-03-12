package com.ssafy.ws;

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
public class MovieAspect {

	@Pointcut("execution(* com.ssafy.ws.*.watching())")
	public void mine() {
	}

	@Before("mine()")
	public void before() {
		System.out.println("영화관을 갑니다.");
	}

	@AfterReturning(value = "mine()")
	public void afterReturning() {
		System.out.println("영화가 끝나고 탈출함");
	}

	@AfterThrowing(value = "mine()", throwing = "except")
	public void afterThrowing(Throwable except) {
		if (except instanceof CallException) {
			((CallException) except).handleException();
		}
	}

	@After("mine()")
	public void after() {
		System.out.println("go to home");
	}

	public void around(ProceedingJoinPoint pjt) {
		try {
			this.afterReturning();
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}
}
