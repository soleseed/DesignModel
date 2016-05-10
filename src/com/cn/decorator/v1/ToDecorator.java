package com.cn.decorator.v1;

public class ToDecorator {
	public static void main(String[] args) {
		Person person = new Person("seed");
		System.out.println("第一种装扮");
		person.wearBigTrousers();
		person.wearTshirts();
		person.wearSnearkers();
		person.show();

		System.out.println("第2种装扮");
		person.wearBigTrousers();
		person.wearTshirts();
		person.wearSnearkers();
		person.wearTie();
		person.show();
	}
}
