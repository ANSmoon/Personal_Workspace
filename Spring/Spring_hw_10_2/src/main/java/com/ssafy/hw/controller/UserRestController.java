package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-user")
@Tag(name = "UserRestController", description = "USER CRUD")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {
	private final UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 사용자 전체 조회
	@GetMapping("/user")
	public ResponseEntity<?> list() {
		List<User> list = userService.selectAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 사용자 정보 삽입
	@PostMapping("/user")
	public ResponseEntity<?> write(@RequestBody User user) {
		userService.insert(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// id가 같은 사용자 조회
	@GetMapping("/user/{id}")
	public ResponseEntity<User> searchId(@PathVariable("id") String id) {
		User user = userService.searchById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// 이름이 같은 사용자 조회
	@GetMapping("/user/user/{name}")
	public ResponseEntity<User> searchName(@PathVariable("name") String name) {
		User user = userService.searchByName(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// 검색 조건이 일치하는 user 조회
}