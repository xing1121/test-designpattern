package com.sf.wdx.design.decorator;

/**
 * 描述：MilkDecorator
 * @author 80002888
 * @date   2019年6月14日
 */
public class MilkDecorator implements Cafe {

	private Cafe cafe;
	
	public MilkDecorator(Cafe cafe) {
		this.cafe = cafe;
	}

	@Override
	public String getCafeStr() {
		String c = cafe.getCafeStr();
		return addMilk(c);
	}
	
	/**
	 * 加牛奶
	 *	@ReturnType	void 
	 *	@Date	2019年6月14日	上午10:39:36
	 *  @Param
	 */
	private String addMilk(String c){
		return c + " add milk";
	}

}
