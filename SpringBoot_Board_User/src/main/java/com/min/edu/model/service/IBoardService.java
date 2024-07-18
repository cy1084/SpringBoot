package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {

	
	public List<BoardVo> userBoardList();

	public int delflagBoard(Map<String, String[]> map);

	public int writeBoard(BoardVo vo);

	public BoardVo getOneBoard(String seq);

	// 다오를 조합하는 서비스 기능이라서 reply기능은 하나로 묶음
	public int reply(BoardVo vo);

	public List<BoardVo> restoreBoard();

	public int restoreDelflag(String seq);
}
