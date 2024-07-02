package com.ssafy.spring.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.spring.model.dto.Article;

public interface ArticleDao {
	// 기사 생성
	int insertArticle(Article article);

	// 전체 기사 검색
	List<Article> selectAllArticles();

	// 특정 기사 검색
	Article selectArticleById(long id);

	// 기사 업데이트
	int updateArticle(Article article);

	// 기사 삭제
	int deleteArticle(long id);

	// 기사 검색
	List<Article> searchArticles(Map<String, String> map);
}