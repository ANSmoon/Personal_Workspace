package com.multicampus.web;

import java.util.HashMap;
import java.util.Map;

import com.multicampus.web.board.DeleteBoardController;
import com.multicampus.web.board.GetBoardController;
import com.multicampus.web.board.GetBoardListController;
import com.multicampus.web.board.InsertBoardController;
import com.multicampus.web.board.InsertBoardViewController;
import com.multicampus.web.board.UpdateBoardController;
import com.multicampus.web.user.InsertUserController;
import com.multicampus.web.user.InsertUserViewController;
import com.multicampus.web.user.LoginController;
import com.multicampus.web.user.LoginViewController;
import com.multicampus.web.user.LogoutController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	
	public HandlerMapping() {
		// Map에 모든 Controller 객체 등록
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		
		mappings.put("/insertBoardView.do", new InsertBoardViewController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}


	public Controller getController(String path) {
		// path에 해당하는 Controller 객체를 검색하여 리턴한다.
		
		return mappings.get(path);
	}
}