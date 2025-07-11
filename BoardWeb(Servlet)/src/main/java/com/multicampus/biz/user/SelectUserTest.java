package com.multicampus.biz.user;

import java.util.List;

public class SelectUserTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// 회원 목록 검색
		List<UserVO> userList = dao.getUserList();
		
		// CASE - 1
		System.out.println("검색된 회원의 수 : " + userList.size() + "명");
		
		// CASE - 2
		System.out.println("[ 회원 목록 ]");
		for (UserVO user : userList) {
			System.out.println("---> " + user.toString());
		}
		
		
//		// JDBC 관련 변수
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			// 3단계 : PreparedStatement 생성
//			String sql = "select * from users where role = ? order by id asc";
//			stmt = conn.prepareStatement(sql);
//			
//			// 4단계 : SQL 전송
//			// 파라미터(?) 설정
//			stmt.setString(1, "USER");
//			rs = stmt.executeQuery();
//			
//			// 5단계 : 검색 결과 처리
//			System.out.println("[ 회원 목록 ]");
//			while(rs.next()) {
//				System.out.print(rs.getString("ID") + " : ");
//				System.out.print(rs.getString("PASSWORD") + " : ");
//				System.out.print(rs.getString("NAME") + " : ");
//				System.out.print(rs.getString("ROLE") + "\n");
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}

	}

}






