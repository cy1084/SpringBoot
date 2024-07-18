package com.min.edu.anno05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Spring bean configuration을 통해서 xml에 <bean>으로 등록하여 여러 개의 같은 타입의 빈을 만들어냄
	@Component를 통해 작성하면 안된다
 * */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	private String name;
	private String addr;
	private int age;
}
