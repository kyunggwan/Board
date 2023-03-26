package com.kyunggwan.board.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.entity.BoardEntity;
import com.kyunggwan.board.entity.PopularSearchEntity;
import com.kyunggwan.board.repository.BoardRepository;
import com.kyunggwan.board.repository.PopularSearchRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	@Autowired
	PopularSearchRepository popularSearchRepository;

	public ResponseDto<List<BoardEntity>> getTop3() {
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		Date date = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
		try {
			boardList = boardRepository.findTOP3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(null);
		} catch (Exception e) {
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("Success", boardList);
	}

	public ResponseDto<List<BoardEntity>> getList() {

		List<BoardEntity> boardList = new ArrayList<BoardEntity>();

		try {
			boardList = boardRepository.findByOrderByBoardWriteDateDesc();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed("Database Error");
		}

		return ResponseDto.setSuccess("Success", boardList);
	}

	public ResponseDto<List<PopularSearchEntity>> getPopularSearchList() {
		List<PopularSearchEntity> popularSearchList = new ArrayList<PopularSearchEntity>();

		try {
			popularSearchList = popularSearchRepository.findTOP10ByOrderByPopularSearchCountDesc();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("Success", popularSearchList);
	}
}
