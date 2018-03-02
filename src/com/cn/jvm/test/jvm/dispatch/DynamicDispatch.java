package com.cn.jvm.test.jvm.dispatch;

public class DynamicDispatch {

	static abstract class Human {
		abstract void sayHello();
	}

	static class Woman extends Human {

		@Override
		public void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("Woman says hello");
		}

	}

	static class Man extends Human {

		@Override
		public void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("Man says hello");
		}
	}

	public static void main(String[] args) {
		// 动态分派:方法重写的调用 由方法调用者的实际类型决定
		// Human 静态类型, new Man(), new Woman()实际类型
		Human man = new Man();
		Human woman = new Woman();

		man.sayHello();
		woman.sayHello();

		man = new Woman();
		man.sayHello();
	}
}
