package com.multicampus.web.board;

import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.web.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 목록 검색 기능 처리");

		// 1. 사용자 입력정보 추출
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");

		// null check
		if (condition == null)
			condition = "title";
		if (keyword == null)
			keyword = "";

		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setCondition(condition);
		vo.setKeyword(keyword);

		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);

		// 3. Model(DAO)을 이용하여 검색한 데이터를 View(JSP)에서 사용할 수 있도록 request에 등록한다.
		request.setAttribute("boardList", boardList);

		// 4. 화면 이동
		return "getBoardList";
		
	}

}
