package com.sf.wdx.design.adapter;

/**
 * 描述：Voltage220To5ClassAdapter
 * @author 80002888
 * @date   2019年6月6日
 */
public class Voltage220To5ClassAdapter extends Voltage220 implements Voltage5{

	@Override
	public int outPut5() {
		int v220 = outPut220();
		int v5 = v220 / 44;
		System.out.println("我是适配器，我把" + v220 + "转为了" + v5);
		return v5;
	}

	@Override
	public void desc() {
		System.out.println("我自带了输出220V的功能，我也是转换器，拥有输出5V的功能。");
	}

}
