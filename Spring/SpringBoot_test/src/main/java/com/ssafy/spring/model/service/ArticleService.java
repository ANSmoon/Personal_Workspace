package com.ssafy.spring.model.service;

import java.util.List;

import com.ssafy.spring.model.dto.Article;

public interface ArticleService {

	// 등록 기능
	int addArticle(Article article);

	// 전체 조회 기능
	List<Article> findAllArticles();

	// 상세 조회 기능
	Article findArticleById(Long id);

	// 수정 기능
	int updateArticle(Article article);

	// 삭제 기능
	boolean deleteArticle(Long id);

	// 검색 기능
	List<Article> searchArticles(String keyword, String value);
}