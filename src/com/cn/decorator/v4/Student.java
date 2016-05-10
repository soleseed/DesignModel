package com.cn.decorator.v4;

public class Student extends Person {

	public Student(String name) {
		this.name = name;
		this.job = "student";
	}

	@Override
	public void show() {
		System.out.println(name + "的job是学生");
	}

}
