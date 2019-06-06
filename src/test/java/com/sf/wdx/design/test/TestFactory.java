package com.sf.wdx.design.test;

import org.junit.Test;

import com.sf.wdx.design.factory.CatFactory;
import com.sf.wdx.design.factory.DogFactory;
import com.sf.wdx.design.factory.StaticAnimalFactory;
import com.sf.wdx.domain.Animal;
import com.sf.wdx.domain.Cat;
import com.sf.wdx.domain.Dog;

/**
 * 描述：测试工厂模式
 * 	静态工厂模式
 * 	抽象工厂模式
 * @author 80002888
 * @date   2019年6月6日
 */
public class TestFactory {
	
	/**
	 * 测试静态工厂模式
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午5:30:09
	 *  @Param
	 */
	@Test
	public void testStaticAnimalFactory() {
		// 新建一个Cat
		Animal animal1 = StaticAnimalFactory.getAnimal(Cat.class);
		System.out.println(animal1);
		// 新建一个Dog
		Animal animal2 = StaticAnimalFactory.getAnimal(Dog.class);
		System.out.println(animal2);
	}
	
	/**
	 * 测试抽象工厂模式
	 * 	相对于静态工厂使用灵活，增加方便。
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午4:40:04
	 *  @Param
	 */
	@Test
	public void testAbstractFactory() {
		// 新建一个Cat
		Animal animal1 = new CatFactory().getAnimal();
		System.out.println(animal1);
		// 新建一个Dog
		Animal animal2 = new DogFactory().getAnimal();
		System.out.println(animal2);
	}
	
}
