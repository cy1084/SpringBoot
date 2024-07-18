package com.min.edu.aop06;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//around - 비포보다 먼저 실행
@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * com.min.edu.aop06..*(..))") //모든
	public void usePersonPointCut() {};
	
	@Before("usePersonPointCut()")
	public void before() {
		System.out.println("우뇌 생각 시작 before");
	}
	
	@After("usePersonPointCut()")
	public void after() {
		System.out.println("우뇌 생각 종료 after");
	}
	
	@Around("usePersonPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("메소드 시작, 공통으로 시작됨 around");
		
		String methodName=joinPoint.getSignature().toShortString();
		
		try {
			System.out.println(methodName+"실행- around");
			
			Object result=joinPoint.proceed(); //결과 가져옴
			System.out.println(methodName+"실행결과: "+result+"-around");
			
			return result;
			
		} catch (Throwable e) {
			System.out.println("예외 처리: "+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	//반환 타입이 있으므로 pointcut으로..?
	@AfterReturning(pointcut = "usePersonPointCut()",returning = "returnValue")
	public void afterReturning(JoinPoint joinpoint, Object returnValue) {
		System.out.println("$$$$$"+joinpoint.getSignature().getName()+"$$$$$");
		
		Object[] args=joinpoint.getArgs();
		System.out.println("리턴 값: "+returnValue+"- @AfterReturning");
	}
	
}
