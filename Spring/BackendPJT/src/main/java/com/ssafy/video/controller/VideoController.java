package com.ssafy.video.controller;

import java.io.IOException;

import com.ssafy.review.model.dto.Review;
import com.ssafy.video.model.service.VideoService;
import com.ssafy.video.model.service.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private VideoService service = VideoServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("videoList", service.getList());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "videoDetail":
				doDetail(request, response);
				break;
			}
		} else {
			doGet(request, response);
		}
	}


	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("videoId"));

		request.setAttribute("videoOne", service.getVideo(id));
		request.getRequestDispatcher("/review/videoDetail.jsp").forward(request, response);
	}

}
