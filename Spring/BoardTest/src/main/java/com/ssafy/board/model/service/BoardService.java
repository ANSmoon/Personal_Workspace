package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardService {
	
	List<Board> getList();
	
	void writeBoard(Board board);
}