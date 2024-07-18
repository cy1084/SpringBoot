package com.min.edu.dto;

//화면의 값을 전달하거나, 요청된 값을 바인드하는 객체
//lombok을 통해서도 가능
public class UserDTO {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + "]";
	}

}
