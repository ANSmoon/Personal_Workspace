package com.ssafy.movie.model.service;

import java.util.List;

import com.ssafy.movie.model.dto.Movie;

public interface MovieService {

	List<Movie> getMovieList();

	void writeMovie(Movie movie);

	void removeMovie(int id);

	Movie readMovie(int id);

}