package com.sf.wdx.design;

import com.sf.wdx.domain.Animal;
import com.sf.wdx.domain.Cat;
import com.sf.wdx.domain.Dog;

/**
 * 3.抽象工厂模式
 * 描述：抽象工厂模式，优点：相对于静态工厂使用灵活，增加方便。
 * @author 80002888
 * @date   2018年6月6日
 */
public class TestAbstractFactory {

	public static void main(String[] args) {
		// 新建一个Cat
		Animal animal1 = new CatFactory().get();
		System.out.println(animal1);
		// 新建一个Dog
		Animal animal2 = new DogFactory().get();
		System.out.println(animal2);
	}
	
}

interface AbstractFactory {
	
	public Animal get();
	
}

class CatFactory implements AbstractFactory{

	@Override
	public Animal get() {
		return new Cat();
	}
	
}

class DogFactory implements AbstractFactory{

	@Override
	public Animal get() {
		return new Dog();
	}
	
}
