package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoLogAop_Anno {

	@Pointcut(value = "execution(public * com.min.edu.model.mapper.*Dao*.*(..))")
	public void daoPointCut() {}
	
	@Before("daoPointCut()")
	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("[AOP Logger] Dao 메소드 실행 전");
		Object[] args = j.getArgs();
		
		if(args != null) {
			logger.info("[AOP Logger] {}", j.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				logger.info(i + "번째" + args[i]);
			}
			logger.info("[AOP Logger] {}", j.getSignature().getName());
		}
	}
	
	@AfterReturning(pointcut = "daoPointCut()", returning = "returnValue")
	public void afterReturing(JoinPoint j, Object returnValue) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("[AOP Logger] 반환결과 : \t {}", returnValue);
	}
	
	@AfterThrowing(pointcut = "daoPointCut()", throwing = "error")
	public void afterThrowing(JoinPoint j, Exception error) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("[AOP Logger] 오류 : \t {}" , error.getMessage());
	}
	
	
}
