package com.test.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.movie.dao.MovieDao;
import com.test.movie.dto.Movie;

@Service
public class MovierServiceImpl implements MovieService{
	
	private final MovieDao movieDao;
	
	public MovierServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Override
	public List<Movie> getMovieList() {
		return movieDao.selectAll();
	}

}
