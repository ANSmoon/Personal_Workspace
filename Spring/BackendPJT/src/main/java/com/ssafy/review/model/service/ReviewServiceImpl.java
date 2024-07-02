package com.ssafy.review.model.service;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.bcel.Repository;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.repository.ReviewReopsitoryImpl;
import com.ssafy.review.model.repository.ReviewRepository;

public class ReviewServiceImpl implements ReviewService {
	
	private static ReviewService service = new ReviewServiceImpl();
	private static ReviewRepository repository = ReviewReopsitoryImpl.getInstance();
	
	private ReviewServiceImpl() {
	}
	
	public static ReviewService getInstance() {
		return service;
	}

	@Override
	public List<Review> getList(int videoId) { // 리뷰 리스트 가져오기
		return repository.selectAll(videoId);
	}

	@Override
	public Review getReview(int id) { // 리뷰 하나 가져오기
		repository.updateViewCnt(id);
		return repository.selectOne(id);
	}

	@Override
	public void writeReview(Review review) { // 리뷰 작성
		repository.insertReview(review);
		
	}

	@Override
	public void modifyReview(Review review) { // 리뷰 수정
		repository.updateReview(review);
	}

	@Override
	public void removeReview(int id) { // 리뷰 삭제
		repository.deleteReview(id);
	}
}