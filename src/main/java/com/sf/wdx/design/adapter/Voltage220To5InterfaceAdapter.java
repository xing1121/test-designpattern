package com.sf.wdx.design.adapter;

/**
 * 描述：Voltage220To5InterfaceAdapter
 * @author 80002888
 * @date   2019年6月6日
 */
public abstract class Voltage220To5InterfaceAdapter implements Voltage5 {

	@Override
	public void desc(){
		System.out.println("我是Voltage220To5InterfaceAdapter，实现了desc，我的子类不用再实现这个方法。");
	}
	
}
