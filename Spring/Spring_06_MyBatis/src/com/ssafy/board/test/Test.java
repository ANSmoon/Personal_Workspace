package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
		
//		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
////			session.selectOne(null); // 해당 라인의 selectOne과 아래는 출처가 다르다.
//			Board board = dao.selectOne(2);
//			System.out.println(board);
//		}
//		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class);
//			Board board = new Board("title 입력", "작성자 입력", "콘텐츠 입력");
//			dao.insertBoard(board);
//		}
//		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.deleteBoard(2);
//		}
//		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.updateViewCnt(4);
//		}
//		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
//			BoardDao dao = session.getMapper(BoardDao.class);
//			Board board = dao.selectOne(1);
//			board.setContent("Study Hard!");
//			dao.updateBoard(board);
//		}
	}
}