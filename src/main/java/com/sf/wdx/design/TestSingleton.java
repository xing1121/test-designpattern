package com.sf.wdx.design;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 1.单例设计模式
 * 描述：单例设计模式，给出了两种实现方法，静态内部类的方法比较好。
 * @author 80002888
 * @date   2018年9月27日
 */
public class TestSingleton {
	
	/**
	 * 闭锁
	 */
	private Integer total = 100;
	final CountDownLatch latch = new CountDownLatch(total);
	
	/**
	 * 测试普通的单例
	 *	@ReturnType	void 
	 *	@Date	2018年9月27日	下午1:59:08
	 *  @Param  @throws Exception
	 */
	@Test
	public void testSingleton() throws Exception {
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println(singleton);
		System.out.println(singleton2);
		
		System.out.println("-----------------反射攻破单例------------------");
		
		Class<Singleton> clazz = Singleton.class;
		Field field = clazz.getDeclaredField("singleton");
		field.setAccessible(true);
		field.set(singleton, null);
		Singleton singleton3 = Singleton.getInstance();
		System.out.println(singleton3);
		
		System.out.println("----------------多线程获取单例开始-------------------");
		
		// 创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			pool.submit(new MyRunnable(latch) {
				@Override
				public void doRun() {
					// 获取单例
					System.out.println(Singleton.getInstance());
				}
			});
		}
		
		// 使用闭锁，在所有线程都执行完毕后，才会执行latch.await()下面的代码
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------多线程获取单例结束-------------------");
		System.exit(0);
	}
	
	/**
	 * 测试静态内部类的单例
	 *	@ReturnType	void 
	 *	@Date	2018年9月27日	下午1:59:15
	 *  @Param
	 */
	@Test
	public void testSing(){
		System.out.println("----------------多线程获取单例开始-------------------");
		
		// 创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < total; i++) {
			pool.submit(new MyRunnable(latch) {
				@Override
				public void doRun() {
					// 获取单例
					System.out.println(SignInner.getInstance());
				}
			});
		}
		
		// 使用闭锁，在所有线程都执行完毕后，才会执行latch.await()下面的代码
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------多线程获取单例结束-------------------");
		System.exit(0);
	}
	
}

/**
 * 描述：自定义的线程
 * @author 80002888
 * @date   2018年9月27日
 */
abstract class MyRunnable implements Runnable {
	
	private CountDownLatch latch;
	
	public MyRunnable(CountDownLatch latch) {
		this.latch = latch;
	}

	public abstract void doRun();
	
	@Override
	public void run() {
		try {
			doRun();
			// 睡眠2s测试闭锁
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}		
	}
	
}

/**
 * 描述：双重锁单例懒汉式
 * @author 80002888
 * @date   2018年9月26日
 */
class Singleton {

	private volatile static Singleton singleton;
	
	private Singleton() {
	}

	public static Singleton getInstance(){
		if (singleton != null) {
			return singleton;
		}
		synchronized (Singleton.class) {
			if (singleton == null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
	
}

/**
 * 描述：静态内部类实现单例
 * 			静态内部类：当被外部类调用的时候才会初始化加载，且为线程安全，只会加载一次。
 * @author 80002888
 * @date   2018年9月27日
 */

class SignInner {
  private SignInner(){
  }
 
  private static class SingInnerHolder{
     private static SignInner sign = new SignInner();
 }
 
  public static SignInner getInstance(){
    return SingInnerHolder.sign;
  }

}