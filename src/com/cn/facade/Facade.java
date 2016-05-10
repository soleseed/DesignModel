package com.cn.facade;

public class Facade {
	private SubSystemOne subSystemOne;
	private SubSystemTwo subSystemTwo;
	private SubSystemThree subSystemThree;

	public Facade() {
		subSystemOne = new SubSystemOne();
		subSystemTwo = new SubSystemTwo();
		subSystemThree = new SubSystemThree();
	}

	public void facadeMethodA() {
		System.out.println("方法组1");
		subSystemOne.methodOne();
		subSystemTwo.methodTwo();
	}

	public void facadeMethodB() {
		System.out.println("方法组2");
		subSystemOne.methodOne();
		subSystemThree.methodThree();
		subSystemTwo.methodTwo();
	}

	public static void main(String[] args) {
		Facade facade = new Facade();

		facade.facadeMethodA();
		facade.facadeMethodB();
	}
}
