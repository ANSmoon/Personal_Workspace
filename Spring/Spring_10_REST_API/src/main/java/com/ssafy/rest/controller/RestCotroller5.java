package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest5")
public class RestCotroller5 {

	// http://localhose:8080/mvc/rest5/user1
	// form data 형식
	// application/x-www-form-urlencoded
	// form 형식으로 넣어야 함
	@PostMapping("/user1")
	public String test1(@ModelAttribute User user) {
		return user.toString();
	}

	// http://localhose:8080/mvc/rest5/user2
	// Json 형태
	// test 방식으로 넣어야 함
//	{
//		"name" : "ansmoon",
//		"id" : "ssafy"
//	}
	@PostMapping("/user2")
	public String test2(@RequestBody User user) {
		return user.toString();
	}
}