package com.sf.wdx.design.proxy;

import org.junit.Test;

/**
 * 描述：测试代理模式
 * @author 80002888
 * @date   2019年6月14日
 */
public class TestProxy {
	
	/**
	 * 测试用秘书代理老板开会
	 *	@ReturnType	void 
	 *	@Date	2019年6月14日	上午10:46:09
	 *  @Param
	 */
	@Test
	public void testProxy(){
		// 秘书
		Boss proxy = new BossProxy();
		// 开会
		proxy.meeting();
	}
	
}