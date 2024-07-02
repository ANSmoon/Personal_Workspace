package com.ssafy.movie.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Movie DTO")
public class Movie {
	private int id;
	private String title;
	private String director;
	private String genre;
	private int duration;
	private int viewCnt;

	public Movie() {
	}

	public Movie(int id, String title, String director, String genre, int duration, int viewCnt) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.duration = duration;
		this.viewCnt = viewCnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", duration="
				+ duration + ", viewCnt=" + viewCnt + "]";
	}
}