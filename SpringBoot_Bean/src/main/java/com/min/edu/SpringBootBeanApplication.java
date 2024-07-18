package com.min.edu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.min.edu.bean01.FunctionExcution;
import com.min.edu.bean01.SamsungAircon;
import com.min.edu.bean01.SamsungTelevision;
import com.min.edu.inject.UseBean;

@SpringBootApplication
public class SpringBootBeanApplication implements CommandLineRunner{ //CommandLineRunner 많이 쓰임 중요!
	//CommandLineRunner 인터페이스는 구동 시점에, 실행되는 코드가 자바 문자열 아규먼트 배열(String[] args)에 접근해야 할 필요가 있을 때 

	@Autowired
	private UseBean useBean;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanApplication.class, args);
		
		//컨테이너 생성
		ApplicationContext context1=new AnnotationConfigApplicationContext(SamsungAircon.class);
		ApplicationContext context2=new AnnotationConfigApplicationContext(SamsungTelevision.class);
		
		//bean 호출(@Bean, name)
		FunctionExcution airconOn=context1.getBean("airconOn",FunctionExcution.class);
		FunctionExcution airconOff=context1.getBean("powerOff",FunctionExcution.class);
		
		//bean 호출(@Component)
		SamsungTelevision television= context2.getBean("samsungTelevision",SamsungTelevision.class);
	
		//bean 실행
		System.out.println(airconOn);
		System.out.println(airconOff);
		
		television.powerOn();
		television.powerOff();
		
		//남의꺼
		ApplicationContext context= new AnnotationConfigApplicationContext(RemoteMain.class);
		String[] beanDefinitionNames=context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames)); //bean 이름들 한번에 조회
		
		
		//자기꺼
		ApplicationContext contextAll= new AnnotationConfigApplicationContext(SpringBootBeanApplication.class);
		String[] beanDefinitionNameAll=contextAll.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNameAll));
		
		/*
		 * AnnotationConfigApplicationContext(SpringBootBeanApplication.class);를 통해 생성된 bean을 확인하면 오류
		 * 현재 적용된 프로젝트에 빈을 호출하기 때문에 오류 발생!!(말 그대로 자기가 자기꺼 부르니까!)
		 */
	}
	@Override
		public void run(String... args) throws Exception {
			useBean.print();
			
		}

}
