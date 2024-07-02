package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Comic implements Movie {

	public Comic() {
	}

	@Override
	public String getInfo() {
		return "코믹영화";
	}

}
