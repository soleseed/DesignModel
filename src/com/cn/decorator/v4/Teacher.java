package com.cn.decorator.v4;

public class Teacher extends Person {
	public Teacher(String name) {
		this.name = name;
		this.job = "teacher";
	}

	@Override
	public void show() {
		System.out.println(name + "的job是老师");
	}

}
