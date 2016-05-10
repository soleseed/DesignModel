package com.cn.decorator.v2;

public class ToDecorator {
	public static void main(String[] args) {
		TShirts tShirts = new TShirts();
		tShirts.show();
		BigTousers bigTousers = new BigTousers();
		bigTousers.show();
		Person person = new Person("XXX");
		person.show();

	}
}
