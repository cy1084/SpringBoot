package com.min.edu.ctrl;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping(value = "loginForm.do")
	public String loginForm() {
		log.info("UserController loginForm.do 로그인화면 이동");
		return "loginForm";
	}
	
	@GetMapping(value = "signupForm.do")
	public String signupForm() {
		log.info("UserController signupForm.do 회원가입화면 이동");
		return "signupForm";
	}
	
	@GetMapping(value = "duplication.do")
	public String duplication() {
		log.info("UserController duplication.do 아이디 중복체크 화면 이동");
		return "duplication";
	}
	
	@PostMapping(value = "duplicationAjax.do")
	@ResponseBody
	public String duplicationAjax(String checkId) {
		log.info("UserController duplicationAjax.do 아이디 중복확인 REST:",checkId);
		int n = service.isDuplicateCheck(checkId);
		return (n>0)?"false":"true";
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("isc", "true");
//		Gson gson = new GsonBuilder().create(); // 객체생성
//		System.out.println(gson.toJson(map));
//		return gson.toJson(map); 
	}
	
	@PostMapping(value = "signup.do")
	public String signup(UserVo vo, HttpServletResponse response) throws IOException {
		log.info("UserController signup.do 회원가입 : {}", vo);
		int n = service.signupMember(vo);
		if(n == 1) {
			return "redirect:/loginForm.do";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("<script>alert('회원가입에 실패하였습니다'); location.href='./loginForm.do';</script>");
			return null;
		}
	}
	@GetMapping("findIdWindow.do")
	public String findIdWindow() {
		log.info("UserController findIdWindow.do 아이디찾기");
		return "findId";
	}
	
	@PostMapping("findId.do")
	@ResponseBody
	public String findId(@RequestParam Map<String, Object> map) {
		log.info("UserController findId.do 아이디찾기 REST : {}", map);
		String id = service.findId(map);
		return StringUtils.defaultIfEmpty(id, "");
	}
	
	@PostMapping("login.do")
	public String login(@RequestParam Map<String, Object> map, HttpSession session, HttpServletResponse response) throws IOException {
		log.info("UserController login.do 로그인 : {}", map);
		UserVo loginVo = service.getLogin(map);
		response.setContentType("text/html; charset=UTF-8");
		if(loginVo != null) {
			session.setAttribute("loginVo", loginVo);
			session.setMaxInactiveInterval(60*10*5);
			response.getWriter().print("<script>alert('로그인이 되었습니다'); location.href='./boardList.do';</script>");
			return null;
		} 
		response.getWriter().print("<script>alert('로그인 정보가 없습니다'); location.href='./loginForm.do';</script>");
		return null;
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session, HttpServletResponse response) {
		log.info("UserController logout.do 로그아웃");
		session.invalidate();
		return "redirect:/loginForm.do";
	}
	
	@GetMapping("managementUser.do")
	public String managementUser(Model model) {
		log.info("BoardController managementUser.do 회원관리");
		List<UserVo> listsVo = service.getAllUser();
		model.addAttribute("listsVo", listsVo);
		return "managementUser";
	}
	
	@GetMapping(value = "/userSelectAll.do")
	public String userSelectAll(Model model) {
		log.info("UserController userSelectAll.do [관리자]회원 전체조회 :");
		List<UserVo> lists = service.userSelectAll();
		model.addAttribute("lists", lists);
		return "userSelectAll";
		
	}
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getSearchUser.do")
	@ResponseBody
	public String getSearchUser(String opt, String keyword, UserVo vo) {
		log.info("UserController getSearchUser.do 회원검색 REST :{} ,{}", vo.getOpt(), vo.getKeyword());
		List<UserVo> lists = service.getSearchUser(vo);
			 
			Gson gson = new GsonBuilder().create();
			 System.out.println(gson.toJson(lists)); 
			 return gson.toJson(lists);
	}
	
	@GetMapping(value = "/userSelectOne.do")
	public String userSelect(String id, Model model) {
		log.info("UserController userSelect.do 상세검색 {}", id);
		UserVo vo = service.userSelectOne(id);
		model.addAttribute("vo",vo);
		return "userSelectOne";

	}
}