package com.kyunggwan.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.entity.BoardEntity;
import com.kyunggwan.board.entity.PopularSearchEntity;
import com.kyunggwan.board.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/top3")
	public ResponseDto<List<BoardEntity>> getTop3() {
		return boardService.getTop3();
	}

	@GetMapping("/list")
	public ResponseDto<List<BoardEntity>> getList() {
		return boardService.getList();
	}

	@GetMapping("/popularsearchList")
	public ResponseDto<List<PopularSearchEntity>> getPopularSearchList() {
		return boardService.getPopularSearchList();
	}

	@GetMapping("/search{boardTitle}")
	public ResponseDto<List<BoardEntity>> getSearchList(@PathVariable("boardTitle") String title) {
		return boardService.getSearchList(title);
	}

}
