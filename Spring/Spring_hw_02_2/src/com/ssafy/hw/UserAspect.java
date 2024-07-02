package com.ssafy.hw;

public class UserAspect {
	
	 public void before() {
	 	System.out.println("어플리케이션 시작스");
	 }
	
	 // method 정상 작동 후
	 public void afterReturn() {
	 	System.out.println("어플리케이션 사용");
	 }
	
	 // method error 발생 후
	 public void afterThrow() {
			System.out.println("문제가 생겨 점검합니다.");
	 }
	
	 // method 정상 종료 후
	 public void after() {
	 	System.out.println("어플리케이션 사용 종료");
	 }
}