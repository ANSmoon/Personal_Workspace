package com.ssafy.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest3")
public class RestCotroller3 {
	
	// http://localhose:8080/mvc/rest3/test1
	@GetMapping("/test1")
	public String test1() {
		return "@GetMapping";
	}
	
	// http://localhose:8080/mvc/rest3/test2
	@PostMapping("/test2")
	public String test2() {
		return "@PostMapping";
	}
	
	// http://localhose:8080/mvc/rest3/test3
	@PutMapping("/test3")
	public String test3() {
		return "@PutMapping";
	}
	
	// http://localhose:8080/mvc/rest3/test4
	@DeleteMapping("/test4")
	public String test4() {
		return "@DeleteMapping";
	}
}