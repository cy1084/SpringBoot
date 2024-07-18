package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	@GetMapping("boardList.do")
	public String boardList(Model model, HttpServletResponse response) {
		log.info("BoardController boardList.do 게시글 전체보기");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setDateHeader("Expires", 0);
		
		List<BoardVo> lists = service.userBoardList();
		for(BoardVo vo : lists) {
			String title = vo.getTitle();
			title = title.replaceAll("<", "&lt;");
			title = title.replaceAll(">", "&gt;");
			vo.setTitle(title);
			String content = vo.getContent();
			if(content != null) {
				content = content.replaceAll("<", "&lt;");
				content = content.replaceAll(">", "&gt;");
				vo.setContent(content);
			}
		}
		model.addAttribute("lists", lists);
		return "boardList";
	}
	
	@PostMapping(value = "/multiDel.do")
	@GetMapping(value = "/multiDel.do")
	public String multiDel(@RequestParam("chkVal") String[] seqs, @RequestParam List<String> chkVal) {
		log.info("BoardController multiDel.do 다중삭제 : {}/{}",seqs, chkVal);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		int n = service.delflagBoard(map);
		log.info("다중삭제된 결과 : {}",n);
		return "redirect:/boardList.do";
	}
	
	@GetMapping(value = "/insertBoard.do")
	public String inserBoard() {
		log.info("BoardController inserBoard.do 새글쓰기 화면");
		return "writeBoardForm";
	}
	
	@PostMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVo vo, HttpSession session) {
		log.info("BoardController inserBoard.do 새글 쓰기 입력 : {} {}",vo.getTitle(),vo.getContent());
		String id = ((UserVo)session.getAttribute("loginVo")).getId();
		vo.setId(id);
		int n = service.writeBoard(vo);
		
		return (n>0)?"redirect:/boardList.do":"redirect:/logout.do";
	}
	
	@GetMapping(value = "/detailBoard.do")
	public String detailBoard(String seq , Model model) {
		log.info("BoardController /detailBoard.do 상세글 조회: {}", seq);
		BoardVo vo = service.getOneBoard(seq);
		model.addAttribute("vo",vo);
		return "detailBoard";
	}
	
	@GetMapping(value = "/replyInsert.do")
	public String replyInsert(String seq) {
		log.info("BoardController replyInsert.do 답글 입력: {}", seq);
		
		return "replyInsert";
	}
	
	@PostMapping(value = "/replyInsert.do")
	public String replyInsert(BoardVo vo, HttpSession session) {
		log.info("BoardController insertBoard.do 답글입력: {} ", vo);
		String id = ((UserVo)session.getAttribute("loginVo")).getId();
		vo.setId(id);
		
		int n = service.reply(vo);
		
		if(n!=0) {
			return "redirect:/boardList.do";
		}else {
			return "redirect:/replyInsert.do?seq="+vo.getSeq();
		}
	}
	
	@GetMapping(value = "/restoreBoard.do")
	public String restoreBoard(Model model) {
		log.info("BoardController restoreBoard.do 삭제글 리스트 ");
		 List<BoardVo> lists =service.restoreBoard();
		 model.addAttribute("lists", lists);
		return "boardDelList";
	}
	
	@GetMapping(value ="/restoreDetailBoard.do" )
	public String restoreDetailBoard(String seq, Model model) {
		log.info("BoardController restoreDetailBoard.do 삭제글 상세정보 ");
		BoardVo vo = service.getOneBoard(seq);
		model.addAttribute("vo",vo);
		return "boardDetailboard";
	}
	
	@GetMapping(value = "/restoreDelFlag.do")
	public String restoreDelFlag(String seq) {
		log.info("BoardController restoreDelFlag.do 복구 완료 ");
		service.restoreDelflag(seq);
		return "redirect:/boardList.do";
	}
	
	
}
