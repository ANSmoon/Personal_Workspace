package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.SearchCondition;

// bean으로 등록 할수 있도록 Service를 선언한다.
@Service
public class MovieServiceImpl implements MovieService {

	private final MovieDao movieDao; // single ton 방식
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Override
	public List<Movie> getMovieList() {
		return movieDao.selectAll();
	}

	@Override
	public Movie readMovie(String title) {
		return movieDao.selectOne(title);
	}

	@Override
	public void writeMovie(Movie movie) {
		movieDao.insertMovie(movie);
	}

	@Override
	public void writeMovieSelected(Movie movie) {
		movieDao.insertMovieSelected(movie);
	}

	@Override
	public void removeMovie(int id) {
		movieDao.deleteMovie(id);
	}

	@Override
	public void modifyMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}

	@Override
	public List<Movie> search(SearchCondition searchCondition) {
		return movieDao.search(searchCondition);
	}
}