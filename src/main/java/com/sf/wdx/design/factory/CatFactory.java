package com.sf.wdx.design.factory;

import com.sf.wdx.domain.Animal;
import com.sf.wdx.domain.Cat;

/**
 * 描述：CatFactory
 * @author 80002888
 * @date   2019年6月6日
 */
public class CatFactory implements AbstractAnimalFactory {

	@Override
	public Animal getAnimal() {
		return new Cat();
	}
	
}
