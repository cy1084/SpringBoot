package com.min.edu.aop06;

import org.springframework.stereotype.Component;

@Component
public class RightBrain implements IPerson {

	@Override
	public void thinking() {
		System.out.println("오른쪽 뇌가 생각을 했어");

	}
	
	public String use(String action) {
		System.out.println("반환 및 아규먼트가 있는 메소드");
		
		return action+"한다";
	}

}
