package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// login page
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}

	// login 필요
	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
//		
//	}
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());

		// tmp에 들어갈 수 있는 값은?
		// 1. 실제로 로그인이 잘 되었다면 User 객체가 반환되어 사용할 수 잇음
		// 2. 뭔가 아이디나 비밀번호가 틀렸을 경우 Null
		if (tmp == null)
			return "redirect:login";

		// login success (session 영역에 정보를 저장했다.)
		session.setAttribute("loginUser", tmp.getName());

		return "redirect:list";
	}

	// logOut
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate();
		// list 화면으로 갔는데, 로그인 페이지로 이동시킬 수 도 있다.
		return "redirect:list";
	}

	// regist
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signupform";
	}

	@PostMapping("signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		// 성공적으로 회원가입이 되었을 경우
		// 1. 회원가입 축하 페이지 이동

		// 2. login page로 이동

		// 3. 게시글 목록 화면으로 이동
		// 3-1. 지금 User 객체를 그대로 실어서 로그인 요청을 보내기

		// 3-2. 세션 불러다가 직접 등록해버리고 넘어가기

		return "redirect:login";
	}

	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}

}