package com.min.edu.aop;

import org.springframework.stereotype.Component;

//주 기능을 구현한 클래스
@Component
public class Teacher implements Human {

	@Override
	public void classWork() {
		System.out.println("강의 시작");

	}

}
