package com.min.edu.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.dto.EduBoardDto;
import com.min.edu.model.IEduBoardDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EduBoardController {

	@Autowired
	private IEduBoardDao dao;
	
	@GetMapping(value="/")
	public String home() {
		return "redirect:/boardList.do";
	}
	
	@GetMapping(value="/boardList.do")
	public String boardList(Model model) {
		List<EduBoardDto> lists=dao.selectBoardXML();
		model.addAttribute("boardList",lists);
		
		return "boardList";
	}
	
}
