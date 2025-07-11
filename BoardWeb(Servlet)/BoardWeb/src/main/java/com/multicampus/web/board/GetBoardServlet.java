package com.multicampus.web.board;

import java.io.IOException;
import java.io.PrintWriter;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> 글 상세 조회 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		
		// 3. 응답 화면 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
				
		out.println("<html>");
		out.println("<head><title>글 상세</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시 글 상세</h1>");
		out.println("<hr>");
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='500'>");
		
		out.println("<tr>");
		out.println("<td bgcolor='orange' width='100'>제목</td>");
		out.println("<td><input name='title' type='text' value='" + board.getTitle() + "'/></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td bgcolor='orange' width='100'>작성자</td>");
		out.println("<td><input name='writer' type='text' value='" + board.getWriter() + "' disabled/></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td bgcolor='orange' width='100'>내용</td>");
		out.println("<td><textarea name='content' cols='40' rows='10'>" + board.getContent() + "</textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td bgcolor='orange' width='100'>등록일</td>");
		out.println("<td><input name='regDate' type='text' value='" + board.getRegDate() + "' disabled/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td bgcolor='orange' width='100'>조회수</td>");
		out.println("<td><input name='cnt' type='text' value='" + board.getCnt() + "' disabled/></td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("<hr>");
		out.println("<a href='getBoardList.do'>글 목록 화면으로 이동</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}







