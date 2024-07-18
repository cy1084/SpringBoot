package com.min.edu;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.min.edu.model.service.IBoardService;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@SpringBootTest
class SpringBootBoardUserApplicationTests {

	@Autowired
	IBoardService boardService;
	@Autowired
	IUserService userService;
	
	@Test
	void contextLoads() {
		
		List<UserVo> userList = userService.getAllUser();
		List<BoardVo> boardList = boardService.userBoardList();
		
		assertNotNull(userList);
		assertNotNull(boardList);
		
	}

}
