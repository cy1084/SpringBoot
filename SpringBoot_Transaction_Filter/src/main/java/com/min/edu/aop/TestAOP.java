package com.min.edu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP를 통한 로그 처리
@Component
@Aspect
@Slf4j
public class TestAOP {

	@Pointcut("execution(public * com.min.edu.model.mapper.*Mapper.*(..))")
	public void pointCut() {

	}

	@Before(value = "pointcut()")
	public void before(JoinPoint j) {
		log.info("\n\n");
		log.info("AOP 메소드 시작 전");
		log.info("AOP 사용되는 메소드 {}", j.getSignature().getName());

		Object[] obj = j.getArgs();

		if (obj != null) {
			log.info("아규먼츠: {}", Arrays.toString(obj));
		}
		log.info("\n\n");
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterthrowing(JoinPoint j, Exception exception) {
		log.info("\n\n");
		log.info("AOP 사용되는 메소드 {}", j.getSignature().getName());
		log.info("AOP 오류 메시지 {}", exception.getMessage());
		log.info("\n\n");
		
	}
}
