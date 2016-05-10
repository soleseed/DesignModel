package com.cn.adapter.v2;

public abstract class Player {

	protected String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void attack();

	public abstract void defense();
}
