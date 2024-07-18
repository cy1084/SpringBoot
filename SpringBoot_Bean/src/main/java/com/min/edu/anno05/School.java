package com.min.edu.anno05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class School {
/*
 * ByType @Autowired  @Qualifier
 * ByName @Resource(name="")
 */
	
	@Autowired
	@Qualifier(value="stu01") //따라서 이렇게 명시해줘야 함
	private Student student;
	//autowired를 통한 주입은 타입 주입인데 타입이 같은 애가 3개나 있으므로 오류
	
	@Resource(name="stu02") //얘도 명시해주기
	private Student studentResource;

	private int grade;
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudentResource() {
		return studentResource;
	}

	public void setStudentResource(Student studentResource) {
		this.studentResource = studentResource;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public School(Student student, Student studentResource, int grade) {
		super();
		this.student = student;
		this.studentResource = studentResource;
		this.grade = grade;
	}
	
	
	
	
}
