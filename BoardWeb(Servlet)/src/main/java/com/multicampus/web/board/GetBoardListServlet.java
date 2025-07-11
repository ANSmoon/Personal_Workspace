package com.multicampus.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
                                   
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> 글 목록 검색 처리");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");

		// 1. 사용자 입력정보 추출
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		// Null Check
		if(condition == null) condition = "title";
		if(keyword == null) keyword = "";
		
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setCondition(condition);
		vo.setKeyword(keyword);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 3. 응답 화면 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
				
		out.println("<html>");
		out.println("<head><title>글 목록</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시 글 목록</h1>");
		out.println("<h3><font color='red'>" + user.getName() + "</font>님 환영합니다.</h3>");
		out.println("<a href='logout.do'>로그아웃</a>");
		out.println("<hr>");
		
		// 검색 시작
		out.println("<form action='getBoardList.do' method='get'>");
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='800'>");
		out.println("<tr>");
		
		out.println("<td align='right'>");
		out.println("<select name='condition'>");
		
		String searchCondition = (String) request.getAttribute("condition");
		if(searchCondition.equals("title")) {
			out.println("<option value='title' selected>제목");
		} else {
			out.println("<option value='title'>제목");
		}
		if(searchCondition.equals("content")) {
			out.println("<option value='content' selected>내용");
		} else {
			out.println("<option value='content'>내용");
		}
		out.println("</select>");
		out.println("<input name='keyword' type='text' value='" + request.getAttribute("keyword") + "'/>");
		out.println("<input type='submit' value='검색'/>");
		out.println("</td>");
		
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		// 검색 종료
		
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='800'>");
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>번호</th>");
		out.println("<th bgcolor='orange' width='400'>제목</th>");
		out.println("<th bgcolor='orange' width='100'>작성자</th>");
		out.println("<th bgcolor='orange' width='100'>등록일</th>");
		out.println("<th bgcolor='orange' width='100'>조회수</th>");
		out.println("</tr>");
		
		for (BoardVO board : boardList) {
			out.println("<tr>");
			out.println("<td>" + board.getSeq() + "</td>");
			out.println("<td><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
			out.println("<td>" + board.getWriter() + "</td>");
			out.println("<td>" + board.getRegDate() + "</td>");
			out.println("<td>" + board.getCnt() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("<hr>");
		out.println("<a href='insertBoard.html'>글 등록 화면으로 이동</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}







