package com.cn.templateMethod.v2;

public class Test {
	public static void main(String[] args) {
		AbstractClass templateA = new ConcreteClassA();
		templateA.templateMethod();

		AbstractClass templateB = new ConcreteClassB();
		templateB.templateMethod();
	}
}
