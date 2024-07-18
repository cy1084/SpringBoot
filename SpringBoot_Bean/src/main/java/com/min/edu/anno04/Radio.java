package com.min.edu.anno04;

import org.springframework.stereotype.Component;

@Component
public class Radio implements IFunction {
	@Override
	public void powerOn() {
		System.out.println("라디오를 켜다");

	}

	@Override
	public void powerOff() {
		System.out.println("라디오를 끄다");

	}

}
