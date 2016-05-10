package com.cn.decorator.v3;

public class TestDecorator {
	public static void main(String[] args) {
		Person xx = new Person("小菜");

		BigTrousers bt = new BigTrousers();
		TShirts ts = new TShirts();

		bt.decorate(xx);
		ts.decorate(bt);
		ts.show();

		ts.decorate(xx);
		ts.show();
	}
}
