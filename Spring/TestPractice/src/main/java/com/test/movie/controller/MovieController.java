package com.test.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.movie.dto.Movie;
import com.test.movie.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/test")
@Tag(name = "TestController", description = "Test Practice")
public class MovieController {
	private final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	// 영상 전체 조회
	@GetMapping("/movie")
	@Operation(summary = "영상정보 반환", description = "모든 영상들에 대해 정보 반환")
	public ResponseEntity<?> list() {
		List<Movie> list = movieService.getMovieList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
}