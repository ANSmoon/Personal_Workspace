package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

// 사용자 친화적
public interface BoardService {
	// 전체글 가져오기
	public abstract List<Board> getList();
	
	// 게시글 하나만 가져오기
	public abstract Board getBoard(int id);
	
	// 게시글 작성
	public abstract void writeBoard(Board board);
	
	// 게시글 수정
	public abstract void modifyBoard(Board board);
	
	// 게시글 삭제
	public abstract void removeBoard(int id);
}
