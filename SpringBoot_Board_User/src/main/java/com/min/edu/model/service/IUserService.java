package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {

	public UserVo getLogin(Map<String, Object> map);

	public int isDuplicateCheck(String id);

	public int signupMember(UserVo vo);

	public List<UserVo> userSelectAll();

	public UserVo userSelectOne(String id);

	public List<UserVo> getSearchUser(UserVo vo);

	public String findId(Map<String, Object> map);
	
	public List<UserVo> getAllUser();
	
	public String pwChk(Map<String, Object> map);
}
