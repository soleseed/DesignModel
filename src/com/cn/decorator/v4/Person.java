package com.cn.decorator.v4;

public class Person implements IPerson {

	public String name;

	public String job;

	@Override
	public void show() {
		System.out.println(name + "的job是" + job);
	}

}
