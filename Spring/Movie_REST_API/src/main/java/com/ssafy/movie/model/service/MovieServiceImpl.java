package com.ssafy.movie.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.model.dao.MovieDao;
import com.ssafy.movie.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService{

	private final MovieDao movieDao;
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Override
	public List<Movie> getMovieList() {
		return movieDao.selectAll();
	}

	@Override
	public void writeMovie(Movie movie) {
		movieDao.insertMovie(movie);
	}

	@Override
	public void removeMovie(int id) {
		movieDao.deleteMovie(id);
	}

	@Override
	public Movie readMovie(int id) {
		return movieDao.selectOne(id);
	}

}
