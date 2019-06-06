package com.sf.wdx.domain;

/**
 * 描述：Student
 * @author 80002888
 * @date   2019年6月6日
 */
public class Student {

	private String name;

	private Integer age;

	private String sex;

	private Dog dog;
	
	public Student() {
	}

	public Student(String name, Integer age, String sex, Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dog = dog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
