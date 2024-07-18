package com.min.edu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect //Aspect 동작 <aop:aspect>
public class MyCCCAspect {
	
	@Pointcut("execution(public * com.min.edu.aop.*.*(..))")
	public void myClass() {};
	
	@Before("myClass()")
	public void beforeMethod() {
		System.out.println("메소드 실행");
	};
	
	@After("myClass()")
	public void afterMethod() {
		System.out.println("메소드 종료");

	};
	
}
