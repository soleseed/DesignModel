package com.cn.decorator.v2;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("装扮的人" + name);
	}

}
