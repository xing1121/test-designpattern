package com.sf.wdx.design.factory;

import com.sf.wdx.domain.Animal;

/**
 * 描述：StaticAnimalFactory
 * @author 80002888
 * @date   2019年6月6日
 */
public class StaticAnimalFactory {

	/**
	 * 根据动物类获取动物
	 *	@ReturnType	Animal 
	 *	@Date	2019年6月6日	下午4:42:49
	 *  @Param  @param animalName
	 *  @Param  @return
	 */
	public static Animal getAnimal(Class<? extends Animal> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
