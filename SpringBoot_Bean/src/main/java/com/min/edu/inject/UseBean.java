package com.min.edu.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.bean01.RemoteController;

@Component
public class UseBean {
	
	//@Component로 생성된 bean을 멤버필드로 가져와 주입해서 사용
	@Autowired
	private RemoteController samsungTelevision;
	
	public void print() {
		System.out.println("UseBean 실행");
		System.out.println(samsungTelevision.powerOff());
		System.out.println(samsungTelevision.powerOn());
	}
}
