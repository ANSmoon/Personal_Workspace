package com.multicampus.web.board;

import java.io.IOException;
import java.io.PrintWriter;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private String author;
//	private String createDate;

//	public void init(ServletConfig config) throws ServletException {
//		author = config.getInitParameter("Author");
//		createDate = config.getInitParameter("CreateDate");
//	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> 글 상세 조회 처리");
		
		// 0. 세션 체크
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
//		ServletConfig config = getServletConfig();
//		author = config.getInitParameter("Author");
//		createDate = config.getInitParameter("CreateDate");
//		
//		System.out.println("작성자 : " + author);
//		System.out.println("작성일 : " + createDate);
		
		ServletContext context = getServletContext();
		String appName = context.getInitParameter("ApplicationName");
		System.out.println("애플리케이션 이름 : " + appName);
		
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
		
		out.println("<form action='updateBoard.do' method='post'>");
		// 글 수정을 위해서 수정할 게시글의 번호(seq)도 같이 전달해야 한다. 
		out.println("<td><input name='seq' type='hidden' value='" + board.getSeq() + "'/></td>");
		
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

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='submit' value='게시글 수정'/></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		
		out.println("<hr>");
		out.println("<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;");
		
		if(user.getRole().equals("ADMIN")) {
			out.println("<a href='deleteBoard.do?seq=" + board.getSeq() + "'>글삭제</a>&nbsp;&nbsp;&nbsp;");
		}
		
		out.println("<a href='getBoardList.do'>글목록</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();

	}

}







