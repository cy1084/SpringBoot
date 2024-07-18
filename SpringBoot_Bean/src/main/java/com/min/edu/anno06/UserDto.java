package com.min.edu.anno06;

import org.springframework.stereotype.Component;

@Component("userDto")
public class UserDto {

	private String name;
	
	public UserDto() {
		this.name="수요일";
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDto(String name) {
		super();
		this.name = name;
	}
	
	
}

