package com.cn.decorator.v1;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public void wearTshirts() {
		System.out.println("wear 大 T shirt");
	}

	public void wearBigTrousers() {
		System.out.println("wear 大 裤子");
	}

	public void wearSnearkers() {
		System.out.println("wear 破鞋");
	}

	public void wearSuit() {
		System.out.println("wear 西装");
	}

	public void wearTie() {
		System.out.println("wear 领带");
	}

	public void wearLeatherShoes() {
		System.out.println("wear 皮鞋");
	}

	public void show() {
		System.out.println("装扮的人" + name);
	}

}
