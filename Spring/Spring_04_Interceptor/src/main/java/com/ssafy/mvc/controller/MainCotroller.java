package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class MainCotroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String password) {
//		HttpServletRequest session = request.getSession();

		// UserService라는 것을 만들어 호출
		if (id.equals("ssafy") && password.equals("1234")) {
			// login 성공!
			session.setAttribute("id", id);
//			return "index"; // forwarding
			return "redirect:/";
		}

		// 아니라면 다시 로그인으로 이동
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// id 지우기
//		session.removeAttribute("id");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/regist1")
	public String registForm(HttpSession session) {
		
		return "redirect:/regist"; // => redirection 횟수가 너무 많습니다.			
//		return "regist";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	
}