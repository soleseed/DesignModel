package com.cn.adapter.v2;

public class AdapterCenter extends Player {

	private Adaptee adaptee = new Adaptee();

	public AdapterCenter(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		adaptee.setName(name);
	}

	public void attack() {
		adaptee.specialAttack();
	}

	public void defense() {
		adaptee.specialDefense();
	}

}
