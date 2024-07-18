package com.min.edu;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.min.edu.aop06.RightBrain;

//junit jupiter!
//계속 쓰던 4.0 버전 아님
@SpringBootTest
class AOP_JUnitTest {

	@Autowired
	private RightBrain rightBrain;
	
	@Test
	@DisplayName("AOP 테스트")
	void test() {
		//돌려보고 실행결과 캡처
		 //rightBrain.thinking();
		
		rightBrain.use("공부"); //알아서 aop 적용
	}

}
