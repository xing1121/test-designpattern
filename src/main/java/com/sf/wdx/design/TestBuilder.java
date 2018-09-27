package com.sf.wdx.design;

import com.sf.wdx.domain.Student;

/**
 * 4.建造者模式
 * @author 80002888
 * @date   2018年6月6日
 */
public class TestBuilder {
	
	public static void main(String[] args) {
		Student student = new StudentBuilder().setName("张三").build();
		System.out.println(student);
		
		Student student2 = new StudentBuilder().setName("张三").setAge(18).build();
		System.out.println(student2);
		
		Student student3 = new StudentBuilder().setName("张三").setAge(18).setSex("男").build();
		System.out.println(student3);
	}
	
}

class StudentBuilder {
	
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