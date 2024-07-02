package com.ssafy.review.model.dto;

import java.util.Date;

import com.ssafy.video.model.dto.Video;

public class Review {
	private static int no = 1; // 클래스 변수
	private int id;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private int viewCnt;
	private int videoId; // Review가 속한 Video
	
	public Review() {
		
	}
	
	

	public Review(String title, String content, String writer, int videoId) {
		this.id = no++;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = new Date().toString();
		this.videoId = videoId;
		
	}



	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Review.no = no;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate="
				+ regDate + ", viewCnt=" + viewCnt + ", videoID=" + videoId + "]";
	}



	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
}
