package com.cn.jvm.test.jvm.dispatch;

public class StaticDispatch {
	static abstract class Human {
	}

	static class Man extends Human {
	}

	static class Woman extends Human {
	}

	public void sayHello(Human guy) {
		System.out.println("hello,guy!");
	}

	public void sayHello(Man guy) {
		System.out.println("hello,gentlemen!");
	}

	public void sayHello(Woman guy) {
		System.out.println("hello,lady!");
	}

	public static void main(String[] args) {
		// 静态分派:方法重载的调用根据参数的静态类型决定,在编译阶段已经确定
		// Human 静态类型, new Man()实际类型
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sd = new StaticDispatch();
		man = new Woman();
		sd.sayHello(man);
		sd.sayHello(woman);
	}
}
