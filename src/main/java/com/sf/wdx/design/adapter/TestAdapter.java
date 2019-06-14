package com.sf.wdx.design.adapter;

import org.junit.Test;

/**
 * 描述：测试适配器模式
 * 	有220V的电源，可是我需要5V的电源
 * @author 80002888
 * @date   2019年6月6日
 */
public class TestAdapter {

	/**
	 * 类适配器
	 * 	Voltage220需要输出5V，没有这个方法，可以创造一个即有220V又可以输出5V的类。
	 * 	新建一个类Voltage220To5ClassAdapter继承Voltage220、实现Voltage5接口，完成220->5的转换。
	 * 	使用时新建Voltage220To5ClassAdapter的对象，不再使用原来的Voltage220。
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午3:43:52
	 *  @Param  @param args
	 */
	@Test
	public void testClassAdapter(){
		// 直接使用220->5转换器
		Voltage220To5ClassAdapter adapter = new Voltage220To5ClassAdapter();
		// 输出5
		int v5 = adapter.outPut5();
		System.out.println("输出电压" + v5);
		// 输出220
		int v220 = adapter.outPut220();
		System.out.println("输出电压" + v220);
	}
	
	/**
	 * 对象适配器
	 * 	Voltage220需要输出5V，没有这个方法，可以创造一个类，赋予它Voltage220属性和输出5V的方法。
	 * 	新建一个类Voltage220To5ObjectAdapter拥有必需属性Voltage220、实现Voltage5接口，完成220->5的转换。
	 * 	使用时需要新建一个Voltage220的对象，新建一个Voltage220To5ObjectAdapter的对象并将前者赋予后者属性。
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午3:52:34
	 *  @Param
	 */
	@Test
	public void testObjectAdapter(){
		// 新建一个Voltage220的对象
		Voltage220 voltage220 = new Voltage220();
		// 新建一个Voltage220To5ObjectAdapter的对象
		Voltage220To5ObjectAdapter adapter = new Voltage220To5ObjectAdapter(voltage220);
		// 输出5
		int v5 = adapter.outPut5();
		System.out.println("输出电压" + v5);
	}
	
	/**
	 * 接口适配器
	 * 	通过抽象类来实现适配，这种适配稍别于上面所述的适配，当一个接口拥有N多抽象方法，我创建一个实现类可能只需要其中一个方法。
	 * 	新建类Voltage220To5InterfaceAdapter实现Voltage5接口，实现desc方法。
	 * 	使用时需要新建一个Voltage220To5InterfaceAdapter的对象，并实输出5V的方法。
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午4:05:59
	 *  @Param
	 */
	@Test
	public void testInterfaceAdapter(){
		// 新建一个Voltage220To5InterfaceAdapter的对象，并实现输出5V的方法
		Voltage220To5InterfaceAdapter adapter = new Voltage220To5InterfaceAdapter() {
			@Override
			public int outPut5() {
				return 5;
			}
		};
		// 输出5
		int v5 = adapter.outPut5();
		System.out.println("输出电压" + v5);
	}
	
}
