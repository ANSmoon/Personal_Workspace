package com.multicampus.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver("/WEB-INF/board/", ".jsp");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 브라우저의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		// 2. HandlerMapping을 통해 요청을 처리할 Controller를 검색
		Controller ctrl = handlerMapping.getController(path);

		// 3. 검색한 Controller를 실행
		String viewName = ctrl.handleRequest(request, response);

		// 4. Controller가 리턴한 View 이름을 기반으로 이동할 화면 경로를 완성
		String view = null;
		if (!viewName.contains("do")) {
			if (viewName.equals("index")) {
				view = viewName + ".jsp";
			} else {
				view = viewResolver.getView(viewName);
			}
		} else {
			view = viewName;
		}

		// 5. 화면 이동
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}