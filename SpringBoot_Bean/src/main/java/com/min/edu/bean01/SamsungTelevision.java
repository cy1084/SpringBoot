package com.min.edu.bean01;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component //전체가 빈
public class SamsungTelevision implements RemoteController {
	
	@Override
	public FunctionExcution powerOn() {
		log.info("@Component으로 생성된 SamsungTelevision powerOn()");
		return new FunctionExcution("텔레비전을 켜다", "텔레비전");
	}
	@Override
	public FunctionExcution powerOff() {
		log.info("@Component으로 생성된 SamsungTelevision powerOff()");
		return new FunctionExcution("텔레비전을 끄다", "텔레비전");
	}

}
