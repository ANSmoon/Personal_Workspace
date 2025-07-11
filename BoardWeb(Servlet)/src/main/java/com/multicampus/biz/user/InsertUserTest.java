package com.multicampus.biz.user;

public class InsertUserTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// 회원 가입
		UserVO vo = new UserVO();		
		vo.setName("관리자2");
		vo.setId("admin2");
		vo.setRole("USER");
		vo.setPassword("test123");
		dao.insertUser(vo);
		
		// 회원 목록 검색
		dao.getUserList();
		
		
//		// JDBC 관련 변수
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			// 3단계 : PreparedStatement 생성
//			String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
//			stmt = conn.prepareStatement(sql);
//			
//			// 4단계 : SQL 전송
//			// 파라미터(?) 값 설정
//			stmt.setString(1, "admin1");
//			stmt.setString(2, "test123");
//			stmt.setString(3, "ANSMOON");
//			stmt.setString(4, "USER");
//			
//			int count = stmt.executeUpdate();
//			System.out.println(count + "건의 데이터가 처리됨");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}

	}

}






