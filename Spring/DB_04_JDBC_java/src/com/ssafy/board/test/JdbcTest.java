package com.ssafy.board.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {

//	1. JDBC driver load
	public JdbcTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcTest db = new JdbcTest();

		for (Board board : db.selectAll()) {
			System.out.println(board);
		}
			

	}

	// 전체 게시글을 가져오는 method
	private List<Board> selectAll(){
		List<Board> list = new ArrayList<>();
		
		// 2. DB 연결 필요

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone", "ssafy", "ssafy");
			
			// 3.SQL 실행
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM board";
			
			ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				Board board = new Board(); // 바구니 bean 게시글 준비
				board.setId(rs.getInt("id"));
//				board.setId(rs.setInt(1)); // index 1부터 시작
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
			}
		rs.close();
		stmt.close();
		conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
