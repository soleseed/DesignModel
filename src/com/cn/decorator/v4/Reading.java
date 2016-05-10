package com.cn.decorator.v4;

public class Reading extends AbstractDecorator {
	public void show() {
		super.show();

		System.out.println("reading");
	}
}
