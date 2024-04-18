package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.SearchCondition;

public interface MovieDao {
	// 전체 게시글을 조회
	public List<Movie> selectAll();

	// Title에 해당하는 게시글 하나 가져오기
	public Movie selectOne(String title);

	// 게시글 등록
	public void insertMovie(Movie movie);
	
	// 특정 위치에 게시글 등록
	public void insertMovieSelected(Movie movie);

	// 게시글 삭제
	public void deleteMovie(int id);

	// 게시글 수정
	public void updateMovie(Movie movie);
	
	// 검색 기능
	public List<Movie> search(SearchCondition searchCondition);
}
