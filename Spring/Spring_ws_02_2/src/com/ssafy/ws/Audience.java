package com.ssafy.ws;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Audience implements Person{

	@Override
	public void watching() throws CallException {
		System.out.println("영화를 봅니당.");
		if(new Random().nextBoolean()) {
			throw new CallException();
		}
	}
}