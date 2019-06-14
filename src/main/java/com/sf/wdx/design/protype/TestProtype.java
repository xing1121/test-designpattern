package com.sf.wdx.design.protype;

import java.io.Serializable;

import org.junit.Test;

import com.sf.wdx.domain.Dog;

/**
 * 描述：测试原型模式
 * @author 80002888
 * @date   2018年6月6日
 */
public class TestProtype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2497286239857951087L;

	/**
	 * 测试克隆CloneableProtype对象
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午5:46:26
	 *  @Param
	 */
	@Test
	public void testCloneableProtype() {
		// 新建一个原型对象
		CloneableProtype cp = new CloneableProtype(20, new Dog("旺财"));
		System.out.println(cp);
		
		System.out.println("-------------分隔符---------------");
		
		// 浅复制
		CloneableProtype cp2 = (CloneableProtype) cp.clone();
		System.out.println(cp2);
		// flase
		System.out.println(cp.equals(cp2));
		// true
		System.out.println(cp.getIntValue() == cp2.getIntValue());
		// true
		System.out.println(cp.getDog().equals(cp2.getDog()));
		
		System.out.println("-------------分隔符---------------");
		
		// 深复制
		CloneableProtype cp3 = (CloneableProtype) cp.deepClone();
		System.out.println(cp3);
		// flase
		System.out.println(cp.equals(cp3));
		// true
		System.out.println(cp.getIntValue() == cp3.getIntValue());
		// false
		System.out.println(cp.getDog().equals(cp3.getDog()));
	}
	
}
