package com.sf.wdx.design.protype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sf.wdx.domain.Dog;

/**
 * 描述：CloneableProtype
 * @author 80002888
 * @date   2019年6月6日
 */
public class CloneableProtype implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5770743877943366270L;
	
	private int intValue;
	
	private Dog dog;
	
	public CloneableProtype() {
	}
	
	public CloneableProtype(int intValue, Dog dog) {
		this.intValue = intValue;
		this.dog = dog;
	}
	
	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	@Override
	public String toString() {
		return "CloneableProtype [intValue=" + intValue + ", dog=" + dog + "]";
	}

	/**
	 * 浅复制：
	 * 将一个对象复制后，基本数据类型的属性都会重新创建，而引用类型的属性指向的还是原对象所指向的。
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 深复制：
	 * 将一个对象复制后，不论是基本数据类型还是引用类型的属性，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制。
	 */
	public Object deepClone() {
        try {
			// 写入当前对象的二进制流  
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
			ObjectOutputStream oos = new ObjectOutputStream(bos);  
			oos.writeObject(this);  
  
			// 读出二进制流产生的新对象  
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
			ObjectInputStream ois = new ObjectInputStream(bis);  
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}  
        return null;
	}
	
}
