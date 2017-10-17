package com.cn.test;

public class ClassC extends ClassA {
	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		ClassC c = new ClassC();

		a.list.add("A");
		a.a++;
		b.list.add("B");
		b.a++;
		c.list.add("C");
		c.a++;
		a.print();
		b.print();
		c.print();
	}
}
