package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 핵심 class
@Component(value = "A")
public class Audience {
	private Movie movie;
	
	// 기본 생성자
	public Audience() {
	}
	
	// 생성자 주입
	@Autowired
	public Audience(@Qualifier("comic") Movie movie) {
		this.movie = movie;
	}

	
	// 설정자 주입
//	@Autowired
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public void printing() {
		System.out.println(movie.getInfo() + "를 관람합니다.");
	}
	
}
