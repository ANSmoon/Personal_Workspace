package com.ssafy.movie.model.dao;

import java.util.List;

import com.ssafy.movie.model.dto.Movie;

public interface MovieDao {

	List<Movie> selectAll();

	void insertMovie(Movie movie);

	void deleteMovie(int id);

	Movie selectOne(int id);
}