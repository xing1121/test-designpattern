package com.sf.wdx.design.test;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.sf.wdx.design.signleton.DCLLazySingleton;
import com.sf.wdx.design.signleton.StaticInnerClassSingleton;

/**
 * 描述：测试单例设计模式
 * 	测试能否创建多个实例
 * @author 80002888
 * @date   2018年9月27日
 */
public class TestSingleton {
	
	/**
	 * 总数
	 */
	private final int TOTAL = 100;
	
	/**
	 * 闭锁
	 */
	private final CountDownLatch LATCH = new CountDownLatch(TOTAL);
	
	
	/**
	 * 测试普通的单例
	 * 	可以被反射攻破
	 *	@ReturnType	void 
	 *	@Date	2018年9月27日	下午1:59:08
	 *  @Param  @throws Exception
	 */
	@Test
	public void testDCLLazySingleton() throws Exception {
		
		System.out.println("----------------多线程获取单例开始-------------------");
		// 创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < TOTAL; i++) {
			pool.submit(new FetchSingletonRunnable(LATCH) {
				@Override
				public void fetchSingletonObjAndPrint() {
					System.out.println(DCLLazySingleton.getInstance());
				}
			});
		}
		// 使用闭锁，在所有线程都执行完毕后，才会执行latch.await()下面的代码
		try {
			LATCH.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------------多线程获取单例结束-------------------");
		
		System.out.println("-----------------直接获取单例开始------------------");
		DCLLazySingleton singleton = DCLLazySingleton.getInstance();
		DCLLazySingleton singleton2 = DCLLazySingleton.getInstance();
		System.out.println(singleton);
		System.out.println(singleton2);
		System.out.println("-----------------直接获取单例结束------------------");
		
		System.out.println("-----------------反射攻破单例开始------------------");
		Class<DCLLazySingleton> clazz = DCLLazySingleton.class;
		Field field = clazz.getDeclaredField("singleton");
		field.setAccessible(true);
		field.set(singleton, null);
		DCLLazySingleton singleton3 = DCLLazySingleton.getInstance();
		System.out.println(singleton3);
		System.out.println("-----------------反射攻破单例结束------------------");
		
		System.exit(0);
	}
	
	/**
	 * 测试静态内部类的单例
	 * 	无法被反射攻破
	 * @throws Exception 
	 *	@ReturnType	void 
	 *	@Date	2018年9月27日	下午1:59:15
	 *  @Param
	 */
	@Test
	public void testStaticInnerClassSingleton() throws Exception{
		System.out.println("----------------多线程获取单例开始-------------------");
		// 创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < TOTAL; i++) {
			pool.submit(new FetchSingletonRunnable(LATCH) {
				@Override
				public void fetchSingletonObjAndPrint() {
					System.out.println(StaticInnerClassSingleton.getInstance());
				}
			});
		}
		// 使用闭锁，在所有线程都执行完毕后，才会执行latch.await()下面的代码
		try {
			LATCH.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----------------多线程获取单例结束-------------------");
		
		System.out.println("-----------------直接获取单例开始------------------");
		StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
		StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getInstance();
		System.out.println(singleton);
		System.out.println(singleton2);
		System.out.println("-----------------直接获取单例结束------------------");
		
		System.out.println("-----------------反射攻破单例开始------------------");
		Class<StaticInnerClassSingleton> clazz = StaticInnerClassSingleton.class;
		// 无法获取静态内部类
		System.out.println(clazz);
		System.out.println("-----------------反射攻破单例结束------------------");

		System.exit(0);
	}
	
}

/**
 * 描述：获取单例实例
 * @author 80002888
 * @date   2018年9月27日
 */
abstract class FetchSingletonRunnable implements Runnable {
	
	private CountDownLatch latch;
	
	public FetchSingletonRunnable(CountDownLatch latch) {
		this.latch = latch;
	}
	
	/**
	 * 获取单例对象并打印
	 *	@ReturnType	void 
	 *	@Date	2019年6月6日	下午4:31:03
	 *  @Param
	 */
	public abstract void fetchSingletonObjAndPrint();

	@Override
	public void run() {
		try {
			// 获取单例对象并打印
			fetchSingletonObjAndPrint();
			// 睡眠2s测试闭锁
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}		
	}
	
}
