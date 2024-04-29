package com.ssafy.spring.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.model.dao.ArticleDao;
import com.ssafy.spring.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleDao articleDao;

	// 의존성 주입
	// singleton 방식 선언
	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	// 2-1. 등록 기능
	@Override
	public int addArticle(Article article) {
		return articleDao.insertArticle(article);
	}
	
	// 2-2. 전체 조회 기능
	@Override
	public List<Article> findAllArticles() {
		return articleDao.selectAllArticles();
	}

	// 2-3. 상세 조회 기능
	@Override
	public Article findArticleById(Long id) {
		return articleDao.selectArticleById(id);
	}

	// 2-4. 수정 기능
	@Override
	public int updateArticle(Article article) {
		// 수정했으면 1을 못했으면 0을 반환한다.
		if(articleDao.updateArticle(article) == 1) {
			return 1;
		}
		return 0;
	}

	// 2-5. 삭제 기능
	@Override
	public boolean deleteArticle(Long id) {
		if(articleDao.deleteArticle(id) == 1) { // 삭제 성공시 1 반환
			return true;
		}
		return false; // 삭제 실패시 false 반환
	}

	// 2-6. 검색 기능
	// title과 keyword를 검색하는 service
	@Override
	public List<Article> searchArticles(String keyword, String value) {
		Map<String, String> map = new HashMap<>();
		map.put(keyword, value);
		return articleDao.searchArticles(map);
	}
}