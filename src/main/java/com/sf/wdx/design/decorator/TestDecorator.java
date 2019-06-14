package com.sf.wdx.design.decorator;

import org.junit.Test;

/**
 * 描述：测试装饰模式
 * @author 80002888
 * @date   2019年6月14日
 */
public class TestDecorator {

	/**
	 * 测试对咖啡加装饰
	 *	@ReturnType	void 
	 *	@Date	2019年6月14日	上午10:46:09
	 *  @Param
	 */
	@Test
	public void testDecorator(){
		// 普通咖啡
		Cafe cafeImpl = new CafeImpl();
		System.out.println(cafeImpl.getCafeStr());
		// 加牛奶咖啡
		Cafe milkCafe = new MilkDecorator(cafeImpl);
		System.out.println(milkCafe.getCafeStr());
		// 加糖咖啡
		Cafe sugarCafe = new SugarDecorator(cafeImpl);
		System.out.println(sugarCafe.getCafeStr());
	}
	
}
