package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dto.Review;


public interface ReviewService {
	//전체글 가져오기
		public abstract List<Review> getList(int videoId);
		
		//게시글 하나 가져오기
		public abstract Review getReview(int id);
		
		//게시글 작성
		public abstract void writeReview(Review review);
		
		//게시글 수정
		public abstract void modifyReview(Review review);
		
		//게시글 삭제
		public abstract void removeReview(int id);
}
