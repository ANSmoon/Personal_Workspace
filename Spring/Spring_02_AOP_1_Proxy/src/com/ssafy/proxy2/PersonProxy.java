package com.ssafy.proxy2;

import java.util.Random;

public class PersonProxy implements Person{

	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("Computer를 부팅한다."); // 이전에 수행해야 할 단계
		try {
			person.coding(); // 핵심 관심 사항
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git 고수다."); // 이상없이 마무리가 되었을 때
		} catch (OuchException e) {
			System.out.println("집에서 불려온다."); // 예외 발생
		} finally {
			System.out.println("집가고 싶다."); // 모든 과정이 끝났을 경우
		}
	}
	

}
