package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board")
@Tag(name = "BoardRestController", description = "게시판 CRUD")
public class BoardRestController {
	private final BoardService boardService;

	@Autowired // => 생성자가 하나밖에 없기 때문에 알아서 주입이 되어 굳이 필요하지 않는다.
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

//	// 게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<?> list() {
//		List<Board> list = boardService.getBoardList(); // 전체 조회
//
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//	}

	// 게시글 (검색) 조회
	@GetMapping("/board")
	@Operation(summary = "게시글 조회", description = "게시글 조건에 따른 조회 가능")
	public ResponseEntity<?> list(@Parameter(description = "검색 조건") @ModelAttribute SearchCondition condition) {
		List<Board> list = boardService.search(condition); // 검색 조회
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	
	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id); // 조회수도 1 증가

		// 만약 가져왔는데 board가 null이면 예외처리를 해줘야 한다!

		// NoContent => 실제 내용이 없음 (직접 구현)

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// 게시글 등록 (Form 형식)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board) {
		// 처리방법 2가지
		// 1. Form 형식 / 2. JSON 형식
		// 등록 게시글을 보냈는데
		boardService.writeBoard(board);

		// 등록이 되었는지 눈으로 Talend API 보려고 이렇게 보낸거지
		// 실제로 front에게 보낼때는 크게 의미 없다. ID만 보내서 detail을 쏘던지 바로 목록으로 가면 필요없음!

		// insert, update, delete -> 반환값이 int 형으로 넘어온다.(data의 개수가 반환됨)

		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	// 특정 위치에 게시글 등록 (Form 형식)
	@PostMapping("/board/{id}")
	public ResponseEntity<?> writeSelected(@ModelAttribute Board board, @PathVariable("id") int id) {
		// 처리방법 2가지
		// 1. Form 형식 / 2. JSON 형식
		// 등록 게시글을 보냈는데
		board.setId(id);
		boardService.writeBoardSelected(board);

		// 등록이 되었는지 눈으로 Talend API 보려고 이렇게 보낸거지
		// 실제로 front에게 보낼때는 크게 의미 없다. ID만 보내서 detail을 쏘던지 바로 목록으로 가면 필요없음!

		// insert, update, delete -> 반환값이 int 형으로 넘어온다.(data의 개수가 반환됨)

		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {
		// JSON 형태의 data
		board.setId(id);
		boardService.modifyBoard(board); // id를 따로 보내왔다면 바구니(DTO)에 넣어놓고 보내기

		return new ResponseEntity<Void>(HttpStatus.OK); // 조금 더 세밀하게 컨트롤 할 수 있다.
	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	@Hidden
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		// 반환값에 따라 실제로 지워졌는지 or 글이 존재하지 않는 경우 등의 상황에 따라
		// 응답 코드가 바뀌면 font에서 처리하기가 더욱 수월해 진다.
		boardService.removeBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}