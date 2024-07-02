package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.SearchCondition;

public interface MovieService {
	// 게시글 전체 조회
	public List<Movie> getMovieList();

	// 게시글 상세조회
	public Movie readMovie(String title); // Dao -> 뷰카운트 +1 / 게시글 조회
	
	// 게시글 작성
	public void writeMovie(Movie movie);

	// 특정 위치에 게시글 작성
	public void writeMovieSelected(Movie movie);

	/// 게시글 삭제
	public void removeMovie(int id);

	// 게시글 수정
	public void modifyMovie(Movie movie);

	// 게시글 검색
	public List<Movie> search(SearchCondition searchCondition);
}
