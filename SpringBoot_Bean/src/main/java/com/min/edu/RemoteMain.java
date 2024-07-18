package com.min.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.min.edu.anno04.Radio;

@ComponentScan(basePackages = "com.min.edu.anno04")
public class RemoteMain {

	public static void main(String[] args) {
		ApplicationContext bean=new AnnotationConfigApplicationContext(RemoteMain.class);
		Radio obj=bean.getBean("radio",Radio.class);
		
		
		obj.powerOff();
		obj.powerOn();
		

	}

}
