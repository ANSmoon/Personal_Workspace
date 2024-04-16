package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {

	@Autowired
	UserService us;

	@GetMapping("/user")
	public ResponseEntity<?> selectAll() {
		 try {
		 	List<User> users = us.selectAll();
		 	if (users==null) {
		 		return new ResponseEntity<>("사람이 없슴다", HttpStatus.NOT_FOUND);
		 	} else {
		 		return new ResponseEntity<>(users, HttpStatus.OK);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
		 try {
		 	User user = us.searchById(id);
		 	if (user == null) {
		 		return new ResponseEntity<>("그딴 id는 없습니다.",HttpStatus.NOT_FOUND);
		 	} else {
		 		return new ResponseEntity<>(user, HttpStatus.OK);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@GetMapping("/user/search")
	public ResponseEntity<?> search(SearchCondition con) {
		 try {
		 	List<User> users = us.searchByCondition(con);
		 	if (users == null) {
		 		return new ResponseEntity<>("그런 사람 없습니다.",HttpStatus.NOT_FOUND);
		 	} else {
		 		return new ResponseEntity<>(users,HttpStatus.OK);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@PostMapping("/user")
	public ResponseEntity<?> insert(User user) {
		 try {
		 	int result = us.insert(user);
		 	
		 	return new ResponseEntity<>(user, HttpStatus.CREATED);

		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
