package com.ssafy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.spring.model.dto.Article;
import com.ssafy.spring.model.service.ArticleService;



@RestController
@RequestMapping("/api")
public class ArticleController {

	private final ArticleService articleService;

	// 의존성 주입
	// singleton 방식 선언
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	// 2-1. 등록 기능
	@PostMapping("/article")
	public ResponseEntity<Integer> insert(@RequestBody Article article) {
		// JSON 형식으로 입력받아햐 하므로 @RequestBody를 사용하며,
		// 정상적으로 입력이 받아지면 1을 반환한다.
		int pass = articleService.addArticle(article);
		if (pass == 0) {
			return new ResponseEntity<>(pass, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(pass, HttpStatus.OK);
	}

	// 2-2. 전체 조회 기능
	@GetMapping("/article")
	public ResponseEntity<List<Article>> list() {
		List<Article> list = articleService.findAllArticles();
		// 등록된 내용이 없을 시 오류 처리
		if (list == null || list.size() < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// 등록된 내용 정상 출력시
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	// 2-3. 상세 조회 기능
	@GetMapping("/article/{id}")
	public ResponseEntity<?> detail(@PathVariable("id") Long id) {
		// id와 일치한 article 객체 정보를 찾는다.
		Article one = articleService.findArticleById(id);
		// 만약 찾지 못했을 경우의 오류를 처리하고
		if (one == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// 찾았다면 해당 id를 갖는 정보를 반환한다.
		return new ResponseEntity<Article>(one, HttpStatus.OK);
	}

	// 2-4. 수정 기능
	@PutMapping("/article/{id}")
	public ResponseEntity<?> update(@RequestBody Article article, @PathVariable("id") Long id) {
		// id와 일치한 article 객체 정보를 수정한다.
		//int pass = articleService.updateArticle(articleService.findArticleById(id));
		article.setId(id);
		int pass = articleService.updateArticle(article);
		// 만약 수정하지 못했다면 오류처리를
		if (pass == 0) {
			return new ResponseEntity<>(pass, HttpStatus.NOT_FOUND);
		}
		// 수정에 성공했다면 1을 반환한다.
		return new ResponseEntity<>(pass, HttpStatus.OK);
	}

	// 2-5. 삭제 기능
	@DeleteMapping("/article/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		// 해당 기사를 삭제한 후 pass에 결과를 저장
		boolean pass = articleService.deleteArticle(id);
		// 만약 삭제했다면 no_content를 출력
		if (pass) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		// 삭제하지 못했다면 not_found를 출력
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// 2-6. 검색 기능
	@GetMapping("/article/search")
	public ResponseEntity<?> search(@RequestParam ("keyword") String keyword, @RequestParam("value") String value) {
		List<Article> list = articleService.searchArticles(keyword, value);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}