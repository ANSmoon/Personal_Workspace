package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest2")
public class RestCotroller2 {

	// http://localhose:8080/mvc/rest1/test1 ==> 404
	// view resolver에게 Hello REST API1 이 view name으로 넘어감
	@GetMapping("/test1")
	public String test1() {
		return "Hello REST API1";
	}

	// http://localhose:8080/mvc/rest1/test2
	// @ResponseBody를 붙이면 이제 viewResolver에게 넘기는 게 아니라 해당 반환값 자체를 client에게 준다.
	@GetMapping("/test2")
	public String test2() {
		return "Hello REST API2";
	}

	// http://localhose:8080/mvc/rest1/test3
	@GetMapping("/test3")
	public Map<String, String> test3() {
		Map<String, String> map = new HashMap<>();
		map.put("id", "ssafy");
		map.put("name", "Yang");
		map.put("password", "1234");
		// key value인데 Json 형태로 알아서 바꿔주면 참 좋을텐데..
		// Jackson을 추가하니 자동을 바꿔줌
		return map;
	}

	// http://localhose:8080/mvc/rest1/test4
	// DTO 자체를 반환하기
	@GetMapping("/test4")
	public User test4() {
		User user = new User("ssafy1", "1234", "ANSMOON");
		return user;
	}
	
	// http://localhose:8080/mvc/rest1/test5
	// User 전체 조회
	@GetMapping("/test5")
	public List<User> test5(){
		List<User> list = new ArrayList<>();

		list.add(new User("ssafy1", "1234", "ANSMOON"));
		list.add(new User("ssafy2", "5678", "IU"));
		list.add(new User("ssafy3", "8765", "Karina"));
		list.add(new User("ssafy4", "4321", "Wonyoung"));
		list.add(new User("ssafy5", "0000", "Yujin"));

		return list;
	}
}