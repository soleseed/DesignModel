package com.cn.decorator.v4;

public class Teaching extends AbstractDecorator {
	public void show() {
		super.show();
		System.out.println("teaching");
	}
}
