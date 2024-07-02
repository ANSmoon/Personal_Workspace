package com.ssafy.board.model.dto;

public class Board {
	private int id;
	private String writer;
	private String content;

	public Board() {
		super();
	}

	public Board(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", writer=" + writer + ", content=" + content + "]";
	}

}
