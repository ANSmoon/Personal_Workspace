package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Movie> movieList = new ArrayList<>();

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

	/**
	 * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 호출해준다.
	 */

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("movieCount", movieList.size());
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = 99;
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));

		// 전달받은 파라미터로 User 객체를 생성하고, attribute에 등록한다.
		Movie movie = new Movie(id, title, director, genre, runningTime);
		request.setAttribute("movie", movie);

		// userList에 사용자 추가
		movieList.add(movie);

		request.setAttribute("movieCount", movieList.size());

		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 클라이언트에서 전달된 request를 분석한 결과를 regist_result.jsp에서 볼 수 있도록 한다.
	 * RequestDispatcher를 사용해서 regist_result.jsp로 forward한다.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// attribute에 지금까지 등록한 영화 리스트, 리스트 수 등록
		request.setAttribute("movies", movieList);
		request.setAttribute("movieCount", movieList.size());

		// forward를 통해 list.jsp 호출
		RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
		disp.forward(request, response);
	}
}
