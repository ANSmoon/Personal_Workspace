package com.ssafy.review.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.review.model.dto.Review;

public class ReviewReopsitoryImpl implements ReviewRepository {
	// 싱글턴 관리
	private static ReviewRepository repository = new ReviewReopsitoryImpl();
	
//	private List<Review> list = new ArrayList<>(); // 리스트 관리
	private Map<Integer, Review> reviews = new HashMap<>();
	
	private ReviewReopsitoryImpl() {
		reviews.put(1, new Review("힘들어요", "진짜 도움 돼요", "홍길동", 1));
		reviews.put(2, new Review("힘들어", "너무 힘든데 최고예요", "김싸피", 1));
		reviews.put(3, new Review("어깨 살려", "진짜 힘들어요", "이삼성", 1));
		reviews.put(4, new Review("어깨 살려2", "진짜 힘들어요2", "2삼성", 2));
		reviews.put(5, new Review("힘들어22", "너무 힘든데 최고2", "2싸피", 2));
	}
	
	public static ReviewRepository getInstance() {
		return repository;
	}
	
	@Override
	public List<Review> selectAll(int videoId) {
		List<Review> tmp = new ArrayList<>();
		for(Review review : reviews.values()) {
			if (review.getVideoId() == videoId) { // videoId와 일치하는 리뷰만 추가
	            tmp.add(review);
	        }
		}
		
		return tmp;
		// return list;
		// return (List<Review>)reviews.values();
	}

	@Override
	public Review selectOne(int id) { // 리뷰 하나
		return reviews.get(id);
	}

	@Override
	public void insertReview(Review review) { // 리뷰 작성
		reviews.put(review.getId(), review);
	}

	@Override
	public void updateReview(Review review) { // 리뷰 수정
		reviews.put(review.getId(), review);
	}

	@Override
	public void deleteReview(int id) { // 리뷰 삭제
		reviews.remove(id);
	}

	@Override
	public void updateViewCnt(int id) { // 조회수
		Review re = reviews.get(id);
		re.setViewCnt(re.getViewCnt()+1);
	}
}