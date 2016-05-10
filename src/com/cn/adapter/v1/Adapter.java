package com.cn.adapter.v1;

public class Adapter extends Target {

	private Adaptee adaptee = new Adaptee();

	public void request() {
		adaptee.specialRequest();
	}

}
