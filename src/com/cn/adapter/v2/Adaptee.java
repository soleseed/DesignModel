package com.cn.adapter.v2;

public class Adaptee {
	private String name;

	public void specialAttack() {
		System.out.println("外籍中锋" + this.name + "进攻");
	}

	public void specialDefense() {
		System.out.println("外籍中锋" + this.name + "防守");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
