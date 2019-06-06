package com.sf.wdx.domain;

/**
 * 描述：Dog
 * @author 80002888
 * @date   2019年6月6日
 */
public class Dog implements Animal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4742402710705228892L;
	private String name;

	public Dog() {
	}

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}
