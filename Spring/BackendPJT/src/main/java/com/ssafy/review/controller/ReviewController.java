package com.ssafy.review.controller;

import java.io.IOException;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.service.ReviewService;
import com.ssafy.review.model.service.ReviewServiceImpl;
import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.service.VideoService;
import com.ssafy.video.model.service.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//의존성 주입
	private ReviewService service = ReviewServiceImpl.getInstance();
	private VideoService service2 = VideoServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 리뷰 요청은 여기 서블릿으로
		String action = request.getParameter("action");
		
		switch(action) {
		case "reviewList":
		doList(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "reviewDetail":
			doDetail(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		}
	
	}
	
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		
		System.out.println("리스트 불러오기");
		request.setAttribute("reviewList", service.getList(videoId));
		request.setAttribute("videoId", videoId);
		Video video = service2.getVideo(videoId);
		request.setAttribute("video", video);
		
		request.getRequestDispatcher("/review/videoDetail.jsp").forward(request, response);
	}
	
	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		
		Review review = new Review(title, content, writer, videoId);
		System.out.println("글작성하기");
		
		service.writeReview(review);
		
//		request.getRequestDispatcher("/review/videoDetail.jsp").forward(request, response);
		response.sendRedirect("review?action=reviewList&videoId="+videoId);
	}
 
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Review review = service.getReview(Integer.parseInt(request.getParameter("id")));
		int videoId = review.getVideoId();
		review.setTitle(request.getParameter("title"));
		review.setContent(request.getParameter("content"));
		
		service.modifyReview(review);
		response.sendRedirect("review?action=reviewList&videoId="+videoId);
//		request.getRequestDispatcher("/review/reviewDetail.jsp").forward(request, response);
		
	}
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Review review = service.getReview(Integer.parseInt(request.getParameter("id")));
		int id = Integer.parseInt(request.getParameter("id"));
		int videoId = review.getVideoId();
		service.removeReview(id);
		response.sendRedirect("review?action=reviewList&videoId="+videoId);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("review", service.getReview(id));
		request.getRequestDispatcher("/review/reviewDetail.jsp").forward(request, response);
	}
}