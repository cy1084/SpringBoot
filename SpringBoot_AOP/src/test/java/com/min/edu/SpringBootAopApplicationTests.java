package com.min.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.min.edu.aop.Human;
import com.min.edu.aop.Student;
import com.min.edu.aop.Teacher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpringBootAopApplicationTests {

	@Autowired
	private Student student;
	
	@Autowired
	private Teacher teacher;
	
	@Test
	@DisplayName("AOP테스트")
	void contextLoads() {
		student.classWork();
		teacher.classWork();
	}

}
