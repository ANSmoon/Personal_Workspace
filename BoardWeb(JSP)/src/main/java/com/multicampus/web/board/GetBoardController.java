package com.multicampus.web.board;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.web.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 기능 처리");
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);

		// 3. Model(DAO)을 통해 검색한 data를 View(JSP)에서 사용할 수 있도록 request에 등록할 수 있다.
		request.setAttribute("board", board);

		// 4. 화면 이동
		return "getBoard";
	}

}
