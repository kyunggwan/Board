package com.kyunggwan.board.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyunggwan.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	public List<BoardEntity> findTOP3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(Date boardWriteDate);

	public List<BoardEntity> findByOrderByBoardWriteDateDesc();

	public List<BoardEntity> findByBoardTitleContains(String boardTitle);
}
