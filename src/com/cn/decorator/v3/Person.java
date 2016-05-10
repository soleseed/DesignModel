package com.cn.decorator.v3;

public class Person {

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	private String name;

	public void show() {
		System.out.println("装扮者" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
