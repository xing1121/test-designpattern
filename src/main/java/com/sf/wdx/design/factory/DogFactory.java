package com.sf.wdx.design.factory;

import com.sf.wdx.domain.Animal;
import com.sf.wdx.domain.Dog;

/**
 * 描述：DogFactory
 * @author 80002888
 * @date   2019年6月6日
 */
public class DogFactory implements AbstractAnimalFactory {

	@Override
	public Animal getAnimal() {
		return new Dog();
	}

}
