package com.ssafy.video.model.dto;

import java.util.List;

import com.ssafy.review.model.dto.Review;

public class Video {
	private static int no = 1; // 클래스 변수
	private int id;
	private String title;
	private String channel;
	private String exInfo;
	private String viewCnt;
	private String videoLink;
	private List<Review> reviews;
	
	public Video() {
		
	}

	public Video(String title, String channel, String exInfo, String videoLink) {
		this.id = no++;
		this.title = title;
		this.channel = channel;
		this.exInfo = exInfo;
		this.videoLink = videoLink;
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Video.no = no;
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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getExInfo() {
		return exInfo;
	}

	public void setExInfo(String exInfo) {
		this.exInfo = exInfo;
	}

	public String getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}


	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", channel=" + channel + ", exInfo=" + exInfo + ", viewCnt="
				+ viewCnt + ", videoLink=" + videoLink + ", reviews=" + reviews + "]";
	}
	
	
	
	
	
}
