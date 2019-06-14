package com.sf.wdx.design.decorator;

/**
 * 描述：SugarDecorator
 * @author 80002888
 * @date   2019年6月14日
 */
public class SugarDecorator implements Cafe {

	private Cafe cafe;
	
	public SugarDecorator(Cafe cafe) {
		this.cafe = cafe;
	}

	@Override
	public String getCafeStr() {
		String c = cafe.getCafeStr();
		return addSugar(c);
	}
	
	/**
	 * 加糖
	 *	@ReturnType	void 
	 *	@Date	2019年6月14日	上午10:39:36
	 *  @Param
	 */
	private String addSugar(String c){
		return c + " add sugar";
	}

}
