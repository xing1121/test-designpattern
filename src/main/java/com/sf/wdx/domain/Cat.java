package com.sf.wdx.domain;

/**
 * 描述：Cat
 * @author 80002888
 * @date   2019年6月6日
 */
public class Cat implements Animal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2245716823023789927L;
	private String name;

	public Cat() {
	}

	public Cat(String name) {
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
		return "Cat [name=" + name + "]";
	}

}
