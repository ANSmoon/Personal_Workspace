package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dto.Movie;

// bean으로 등록 할수 있도록 Service를 선언한다.
@Service
public class MovieServiceImpl implements MovieService {

	private MovieDao movieDao;

	/**
	 * setter를 통해 movieRepo을 주입 받는다.
	 * 
	 * @param movieDao
	 */
	@Autowired
	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	
	@Transactional
	@Override
	public int insert(Movie movie) {
		return movieDao.insert(movie);
	}

	@Override
	public Movie searchById(int id) {
		//코드작성
		return movieDao.searchById(id);
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		//코드작성
		return movieDao.searchByTitle(title);
	}

	@Override
	public List<Movie> selectAll() {
		// 코드작성
		return movieDao.selectAll();
	}
}