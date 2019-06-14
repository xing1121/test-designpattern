package com.sf.wdx.design.builder;

import org.junit.Test;

import com.sf.wdx.domain.Student;

/**
 * 描述：测试建造者模式
 * @author 80002888
 * @date   2019年6月6日
 */
public class TestBuilder {
	
	/**
	 * 测试使用StudentBuilder构建Student对象
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午5:35:29
	 *  @Param
	 */
	@Test
	public void testStudentBuilder(){
		Student student1 = new StudentBuilder().setName("张三").build();
		System.out.println(student1);
		
		Student student2 = new StudentBuilder().setName("张三").setAge(18).build();
		System.out.println(student2);
		
		Student student3 = new StudentBuilder().setName("张三").setAge(18).setSex("男").build();
		System.out.println(student3);
	}
	
}
