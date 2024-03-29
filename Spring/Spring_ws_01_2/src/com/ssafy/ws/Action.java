package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Action implements Movie {

	public Action() {
	}

	@Override
	public String getInfo() {
		return "액션영화";
	}
}