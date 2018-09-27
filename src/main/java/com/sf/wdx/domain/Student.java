package com.sf.wdx.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4258910001367763906L;

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
	
	/**
	 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制。
	 */
	public Object deepClone() {
        try {
			/* 写入当前对象的二进制流 */  
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
			ObjectOutputStream oos = new ObjectOutputStream(bos);  
			oos.writeObject(this);  
  
			/* 读出二进制流产生的新对象 */  
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
			ObjectInputStream ois = new ObjectInputStream(bis);  
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}  
        return null;
	}
	
}
