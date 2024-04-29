package com.ssafy.spring.model.dto;

import java.time.LocalDate;

/**
 * 뉴스 기사 정보를 전달하기 위한 DTO(Data Transfer Object) 클래스입니다.
 */
public class Article {

	private Long id; // 뉴스의 고유 ID
	private String title; // 뉴스 기사 제목
	private String writer; // 기자 이름
	private String agency; // 신문사 이름
	private String content; // 뉴스 기사 본문
	private LocalDate createdAt; // 게시일
	private LocalDate updatedAt; // 수정일

	// 기본 생성자
	public Article() {
	}

	// 매개변수가 있는 생성자
	public Article(String title, String writer, String agency, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.agency = agency;
		this.content = content;
	}

	// Getter and Setter 메소드
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", writer=" + writer + ", agency=" + agency + ", content="
				+ content + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}