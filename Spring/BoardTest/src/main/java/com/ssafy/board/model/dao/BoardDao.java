package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {
	
	void insertBoard(Board board);
	
	List<Board> selectAll();
}
