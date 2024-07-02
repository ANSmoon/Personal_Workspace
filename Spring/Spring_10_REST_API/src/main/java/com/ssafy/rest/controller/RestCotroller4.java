package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest4")
public class RestCotroller4 {
	// http://localhose:8080/mvc/rest4/board1/1
	// http://localhose:8080/mvc/rest4/board2/2
	// http://localhose:8080/mvc/rest4/board3/99
	// @pathVariable : URI 경로에 있는 값을 파라미터 추출해서 사용

	@GetMapping("/board1/{id}")
	public String test1(@PathVariable int id) {
		return id + ": board1";
	}

	@GetMapping("/board2/{id}")
	public String test2(@PathVariable("id") int no) {
		return no + ": board2";
	}
	
	@GetMapping("/board3/{id}/reviews/{reviewId}")
	public String test3(@PathVariable("id") int id, @PathVariable("reviewId") int reviewId) {
		return "board " + id + "=> review : " + reviewId;
	}
	
	
}