package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int movieCount;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			
			HttpSession session = request.getSession();

			Integer movieCount = (Integer)session.getAttribute("count");
			
			// count라는 세션이 없으면 count : 1으로
			// count라는 세션이 있으면 count++
			if(movieCount == null) {
				session.setAttribute("count", 1);
			}else {
				session.setAttribute("count", movieCount + 1);
			}
			break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = 20;
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
		
		request.setAttribute("title", title);
		request.setAttribute("director", director);
		request.setAttribute("genre", genre);
		request.setAttribute("runningTime", runningTime);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
		dispatcher.forward(request, response);
		
	}
}
