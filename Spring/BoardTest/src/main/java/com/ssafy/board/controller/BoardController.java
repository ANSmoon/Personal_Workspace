package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "redirect:list";
	}

	@GetMapping("list")
	public String list(Model model) {
		List<Board> list = boardService.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	
	@GetMapping("write")
	public String writeForm() {
		return "/board/write-form";
	}

	@PostMapping("write")
	public String write(Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}
}
