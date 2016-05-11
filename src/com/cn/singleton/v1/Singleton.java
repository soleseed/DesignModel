package com.cn.singleton.v1;

//懒汉模式，需要用到才初始化
public class Singleton {

	public static Singleton singleton = null;

	// 定义私有构造器，确保外界无法实例化
	private Singleton() {

	}

	// 提供外界访问的方法
	public Singleton getInstance() {
		if (null == singleton) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
