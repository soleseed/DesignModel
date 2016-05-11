package com.cn.singleton.v2;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		return singleton;
	}
}

// 线程同步问题
class Singleton2 {
	private static Singleton2 singleton2 = null;

	private Singleton2() {

	}

	// 每次都要同步锁，性能问题
	public static synchronized Singleton2 getInstance() {
		if (null == singleton2) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}

class Singleton3 {
	private static Singleton3 singleton3 = null;

	private Singleton3() {

	}

	// 每次都要同步锁，性能问题
	public static Singleton3 getInstance() {
		if (null == singleton3) {
			synchronized (Singleton3.class) {
				if (null == singleton3) {
					singleton3 = new Singleton3();
				}
			}
		}
		return singleton3;
	}

}
