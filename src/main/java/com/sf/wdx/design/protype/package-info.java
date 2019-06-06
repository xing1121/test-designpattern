/**
 * 描述：原型模式
 * 	原型模式就是讲一个对象作为原型，复制一个新的对象，需要实现Serializable接口，
 * 	浅克隆使用clone()方法来创建新的实例，不复制引用类型属性的对象。深克隆使用字节流进行复制，完全复制。
 * 	现在很多工具类支持复制对象例如BeanUtils。
 * @author 80002888
 * @date   2019年6月6日
 */
package com.sf.wdx.design.protype;