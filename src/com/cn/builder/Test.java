package com.cn.builder;

public class Test {
	public static void main(String[] args) {
		Conductor con;
		Builder a = new ConcreteBuilderA();
		Builder b = new ConcreteBuilderB();

		con = new Conductor(a);
		a.getProduct().show();

		con = new Conductor(b);
		b.getProduct().show();
	}
}
