package com.min.edu.bean01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration //전체가 빈은 아님
public class SamsungAircon implements RemoteController {
	
	public SamsungAircon() {
		log.info("삼성에어컨 호출");
	}
	
	@Override
	@Bean(name="airconOn")
	public FunctionExcution powerOn() {
		log.info("@Configuration의 Bean으로 생성된 SamsungAircon powerOn()");
		return new FunctionExcution("에어컨을 켜다","에어컨");
	}
	
	@Override
	@Bean
	public FunctionExcution powerOff() {
		log.info("@Configuration의 Bean으로 생성된 SamsungAircon powerOff()");
		return new FunctionExcution("에어컨을 끄다","에어컨");
	}
}
