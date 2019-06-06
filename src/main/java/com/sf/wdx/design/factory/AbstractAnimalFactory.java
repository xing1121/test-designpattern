package com.sf.wdx.design.factory;

import com.sf.wdx.domain.Animal;

/**
 * 描述：AbstractAnimalFactory
 * @author 80002888
 * @date   2019年6月6日
 */
public interface AbstractAnimalFactory {

	/**
	 * 获取动物
	 *	@ReturnType	Animal 
	 *	@Date	2019年6月6日	下午4:41:51
	 *  @Param  @return
	 */
	public Animal getAnimal();
	
}
