package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.MovieService;
import com.ssafy.ws.model.service.UserService;

@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
public class MovieRestController {
	private final MovieService movieService;
	private final UserService userService;

	@Autowired // 생성자가 하나 밖에 없기에 알아서 주입되어 굳이 필요하진 않는다.
	public MovieRestController(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
	}
	
//	@Autowired // 생성자가 하나 밖에 없기에 알아서 주입되어 굳이 필요하진 않는다.
//	public MovieRestController(UserService userService) {
//		this.movieService = userService;
//	}

	// 모든 영화 정보 조회
	// movieapi/movie
	@GetMapping("/movie")
	public ResponseEntity<?> list() {
		List<Movie> list = movieService.getMovieList();
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}

	// 영화 정보 입력
	// movieapi/movie
	@PostMapping("/movie")
	public ResponseEntity<?> write(@ModelAttribute Movie movie) {
		movieService.writeMovie(movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}

	// 영화 정보 삭제
	// movieapi/movie/{id}
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable("id") int id) {
		movieService.removeMovie(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 제목이 일치하는 영화 조회
	// movieapi/movie/{title}
	@GetMapping("movie/{title}")
	public ResponseEntity<Movie> detail(@PathVariable("title") String title){
		Movie movie = movieService.readMovie(title);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

	// id가 일치하는 사용자 조회
	// movieapi/user/{id}
	@GetMapping("user/{id}")
	public ResponseEntity<User> detailUser(@PathVariable("id") String id){
		User user = userService.select(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}