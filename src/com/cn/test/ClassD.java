package com.cn.test;

public class ClassD {

	static abstract class Human {

	}

	static class Man extends Human {
		public void sayHello(Human guy) {
			System.out.println("hello, guy---man");
		}
	}

	static class Woman extends Human {

	}

	public void sayHello(Human guy) {
		System.out.println("hello, guy");
	}

	public void sayHello(Man guy) {
		System.out.println("hello, man");
	}

	public void sayHello(Woman guy) {
		System.out.println("hello, woman");
	}

	public static void main(String[] agrs) {
		Human man = new Man();
		Human woman = new Woman();
		ClassD d = new ClassD();
		d.sayHello(man);
		d.sayHello(woman);
		System.out.println(d.getClass());
		System.out.println(ClassD.class);
	}
}
