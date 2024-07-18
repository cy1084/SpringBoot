package com.min.edu.anno06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component("userServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	
	//생성자 주입
	private final UserDto userDto01;
	
	//멤버필드 주입
	@Autowired
	@Qualifier("userDto")
	public UserDto userDto02;

	@Override
	public void addUser() {
		System.out.println("추가된 인원");

	}

}
