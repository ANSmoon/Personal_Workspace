package com.ssafy.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	
	// 의존성 주입
	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		// 해당 게시글의 조회수를 올리는 작업 우선 시행
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id); // 해당 게시글 반환
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void deleteBoard(int id) {
		boardDao.deleteBoard(id);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}
}