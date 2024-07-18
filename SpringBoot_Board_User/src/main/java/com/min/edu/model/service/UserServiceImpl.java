package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public UserVo getLogin(Map<String, Object> map) {
		log.info("UserServiceImpl getLogin 로그인: {}", map);
		return dao.getLogin(map);
	}

	@Override
	public int isDuplicateCheck(String id) {
		log.info("UserServiceImpl isDuplicateCheck 아이디 중복체크: {}", id);
		return dao.isDuplicateCheck(id);
	}

	@Override
	public int signupMember(UserVo vo) {
		log.info("UserServiceImpl signupMember 회원가입: {}", vo);
		return dao.signupMember(vo);
	}

	@Override
	public List<UserVo> userSelectAll() {
		log.info("UserServiceImpl userSelectAll 회원전체조회");
		return dao.userSelectAll();
	}

	@Override
	public UserVo userSelectOne(String id) {
		log.info("UserServiceImpl userSelectOne 회원상세조회: {}", id);
		return dao.userSelectOne(id);
	}

	@Override
	public List<UserVo> getSearchUser(UserVo vo) {
		log.info("UserServiceImpl getSearchUser 회원검색: {}", vo);
		return dao.getSearchUser(vo);
	}

	@Override
	public String findId(Map<String, Object> map) {
		log.info("UserServiceImpl findId 아이디 찾기: {}", map);
		return dao.findId(map);
	}

	@Override
	public List<UserVo> getAllUser() {
		log.info("UserServiceImpl getAllUser 전체회원조회");
		return dao.getAllUser();
	}

	@Override
	public String pwChk(Map<String, Object> map) {
		log.info("UserServiceImpl pwChk 패스워드 찾기: {}", map);
		return dao.pwChk(map);
	}


	
}
