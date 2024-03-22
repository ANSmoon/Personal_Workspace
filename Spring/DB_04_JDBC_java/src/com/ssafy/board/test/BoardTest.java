package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class BoardTest {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
		// 전부 불러오기
//		for(Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
		
//		System.out.println(dao.selectOne(0));
		
		// 등록
//		Board board = new Board("check 1", "check 2", "check 3");
//		dao.insertBoard(board);
		
//		dao.deleteBoard(5);
//		
//		for(Board b : dao.selectAll()) {
//		System.out.println(b);
//	}

//		// 수정을 하기 위한 기본 data가 확보된 상태
//		Board board = dao.selectOne(4);
//		
//		board.setTitle("update 1");
//		board.setContent("update 2");
//
//		dao.updateBoard(board);
//		
//		for(Board b : dao.selectAll()) {
//		System.out.println(b);
//	}
		
		// 게시글 조회수 올리기
		Board board = dao.selectOne(4);
		dao.updateViewCnt(board.getId());
		
		for(Board b : dao.selectAll()) {
		System.out.println(b);
	}
		
	}
}
