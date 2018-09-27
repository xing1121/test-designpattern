package com.sf.wdx.design;

import com.sf.wdx.domain.Animal;
import com.sf.wdx.domain.Cat;
import com.sf.wdx.domain.Dog;

/**
 * 2.静态工厂模式
 * 描述：静态工厂模式
 * @author 80002888
 * @date   2018年6月6日
 */
public class TestStaticFactory {
	
	public static void main(String[] args) {
		Animal animal1 = AnimalFactory.getAnimalByClassName("Cat");
		Animal animal2 = AnimalFactory.getAnimalByClassName("Dog");
		System.out.println(animal1);
		System.out.println(animal2);
	}
	
}

class AnimalFactory {

	public static Animal getAnimalByClassName(String className) {
		if ("Cat".equals(className)) {
			return new Cat();
		}
		if ("Dog".equals(className)) {
			return new Dog();
		}
		return null;
	}

}
