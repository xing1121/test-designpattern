package com.sf.wdx.design.proxy;

/**
 * 描述：BossProxy -- 秘书
 * @author 80002888
 * @date   2019年6月14日
 */
public class BossProxy implements Boss {

	private Boss boss;
	
	public BossProxy() {
		this.boss = new BossImpl();
	}

	@Override
	public void meeting() {
		System.out.println("start meeting......");
		boss.meeting();
		System.out.println("......meeting end");
	}

}
