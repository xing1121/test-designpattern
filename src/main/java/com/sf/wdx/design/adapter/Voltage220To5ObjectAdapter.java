package com.sf.wdx.design.adapter;

/**
 * 描述：Voltage220To5ObjectAdapter
 * @author 80002888
 * @date   2019年6月6日
 */
public class Voltage220To5ObjectAdapter implements Voltage5 {

	private Voltage220 voltage220;
	
	public Voltage220To5ObjectAdapter(Voltage220 voltage220) {
		this.voltage220 = voltage220;
	}

	@Override
	public int outPut5() {
		int v220 = voltage220.outPut220();
		int v5 = v220 / 44;
		System.out.println("我是适配器，我把" + v220 + "转为了" + v5);
		return v5;
	}

	@Override
	public void desc() {
		System.out.println("我只是转换器，需要插入一个Voltage220才能工作，我拥有输出5V的功能");
	}
	
}
