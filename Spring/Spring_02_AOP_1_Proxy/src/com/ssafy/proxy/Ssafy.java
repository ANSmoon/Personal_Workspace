package com.ssafy.proxy;

import java.util.Random;

public class Ssafy{
	// filed는 과감히 생략한다.

	// Ssafy의 일상
	public void coding() {
		System.out.println("Computer를 부팅한다."); // 이전에 수행해야 할 단계
		try {
			System.out.println("Coding 너무 하기 싫다."); // 핵심 관심 사항
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git 터뜨리고 싶다."); // 이상없이 마무리가 되었을 때
		} catch (OuchException e) {
			System.out.println("집에 도망간다."); // 예외 발생
		} finally {
			System.out.println("집가고 싶다."); // 모든 과정이 끝났을 경우
		}
	}

}
