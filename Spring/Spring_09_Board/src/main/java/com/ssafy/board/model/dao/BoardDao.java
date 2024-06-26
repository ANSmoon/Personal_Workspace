package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {
	// 전체 게시글을 조회
	public abstract List<Board> selectAll();

	// ID와 일치하는 게시글 조회
	public abstract Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);
}