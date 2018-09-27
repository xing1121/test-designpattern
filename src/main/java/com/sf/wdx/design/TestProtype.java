package com.sf.wdx.design;

import com.sf.wdx.domain.Dog;
import com.sf.wdx.domain.Student;

/**
 * 5.原型模式
 * 描述：原型模式就是讲一个对象作为原型，使用clone()方法来创建新的实例。
 * @author 80002888
 * @date   2018年6月6日
 */
public class TestProtype {

	public static void main(String[] args) {
		Student student = new Student("李四", 20, "男",new Dog());
		System.out.println(student);
		
		System.out.println("----------------------------");
		
		// 浅复制
		Student student2 = (Student) student.clone();
		System.out.println(student2);
		System.out.println(student.equals(student2));						// false
		System.out.println(student.getDog().equals(student2.getDog()));		// true
		
		System.out.println("----------------------------");
		
		// 深复制
		Student student3 = (Student) student.deepClone();
		System.out.println(student3);
		System.out.println(student.equals(student3));						// false
		System.out.println(student.getDog().equals(student3.getDog()));		// false
	}
	
}
