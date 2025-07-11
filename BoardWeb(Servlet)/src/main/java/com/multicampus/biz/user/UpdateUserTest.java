package com.multicampus.biz.user;

public class UpdateUserTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// 회원 수정
		UserVO vo = new UserVO();		
		vo.setName("관리자3");
		vo.setId("admin2");
		vo.setRole("ADMIN");
		dao.updateUser(vo);
		
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
//			String sql = "update users set name = ?, role = ? where id = ?";
//			stmt = conn.prepareStatement(sql);
//			
//			// 4단계 : SQL 전송
//			// 파라미터(?) 값 설정
//			stmt.setString(1, "둘리");
//			stmt.setString(2, "ADMIN");
//			stmt.setString(3, "admin1");
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






