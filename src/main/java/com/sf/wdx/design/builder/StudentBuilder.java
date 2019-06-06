package com.sf.wdx.design.builder;

import com.sf.wdx.domain.Student;

/**
 * 描述：StudentBuilder
 * @author 80002888
 * @date   2019年6月6日
 */
public class StudentBuilder {
	
	private Student student = new Student();
	
	public Student build(){
		return student;
	}
	
	public StudentBuilder setName(String name){
		student.setName(name);
		return this;
	}
	
	public StudentBuilder setAge(Integer age){
		student.setAge(age);
		return this;
	}
	
	public StudentBuilder setSex(String sex){
		student.setSex(sex);
		return this;
	}
	
}