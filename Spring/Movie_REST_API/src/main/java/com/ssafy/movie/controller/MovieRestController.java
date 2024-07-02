package com.ssafy.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.movie.model.dto.Movie;
import com.ssafy.movie.model.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movieapi")
@Tag(name = "MovieRestController", description = "영화 CRUD")
public class MovieRestController {
	private final MovieService movieService;
	
	@Autowired
	public MovieRestController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	// READ
	@GetMapping("/movie")
	@Operation(summary = "모든 영화 정보 변환", description = "모든 영화 정보를 반환함")
	public ResponseEntity<?> list(){
		List<Movie> list = movieService.getMovieList();
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
	
	// CREATE
	@PostMapping("/movie")
	public ResponseEntity<?> write(@RequestBody Movie movie){
		movieService.writeMovie(movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}
	
	// DELETE
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		movieService.removeMovie(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// READ ONE
	@GetMapping("/movie/{id}")
	public ResponseEntity<?> listOne(@PathVariable("id") int id){
		Movie movie = movieService.readMovie(id);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
	}
	
}