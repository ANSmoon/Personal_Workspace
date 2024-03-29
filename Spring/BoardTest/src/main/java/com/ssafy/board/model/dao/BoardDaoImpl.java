package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.board.model.dto.Board;

@Component
public class BoardDaoImpl implements BoardDao {
	
	// DB 역할 수행
	List<Board> boardList = new ArrayList<Board>();
	
	@Override
	public void insertBoard(Board board) {
		boardList.add(board);
		
		// Unique 하지 않기 때문에 위험부담이 있는 방식
		board.setId(boardList.size());
		
		System.out.println("게시글 등록 성공!");
		System.out.println(board);
	}

	@Override
	public List<Board> selectAll() {
		return boardList;
	}
	
}
