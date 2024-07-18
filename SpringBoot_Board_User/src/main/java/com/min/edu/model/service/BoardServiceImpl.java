package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements IBoardService{

	@Autowired
	private IBoardDao dao;

	@Override
	public List<BoardVo> userBoardList() {
		log.info("BoardServiceImpl 게시글 전체조회 ");
		return dao.userBoardList();
	}

	@Override
	public int delflagBoard(Map<String, String[]> map) {
		log.info("BoardServiceImpl delflagBoard 게시글 삭제: {}", map);
		return dao.delflagBoard(map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		log.info("BoardServiceImpl writeBoard 게시글 입력: {}", vo);
		return dao.writeBoard(vo);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		log.info("BoardServiceImpl writeBoard 게시글 상세: {}", seq);
		return dao.getOneBoard(seq);
	}

	@Override
//	@Transactional(readOnly = true)
	public int reply(BoardVo vo) {
		log.info("BoardServiceImpl writeBoard 답글 수정 & 입력: 부모의 seq{} / {}", vo.getSeq(), vo);
		int m = dao.replyUpdate(vo);
		int n = dao.replyInsert(vo);
		return (m>0||n>0)?1:0;
	}

	@Override
	public List<BoardVo> restoreBoard() {
		log.info("BoardServiceImpl restoreBoard 삭제된 글 전체조회");
		return dao.restoreBoard();
	}

	@Override
	public int restoreDelflag(String seq) {
		log.info("BoardServiceImpl restoreDelflag 삭제된 글 복구: {}", seq);
		return dao.restoreDelflag(seq);
	}
	
}
