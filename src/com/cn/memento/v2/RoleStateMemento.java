package com.cn.memento.v2;

public class RoleStateMemento {

	private double hp;

	private double mp;

	private double sp;

	public RoleStateMemento(double hp, double mp, double sp) {
		this.hp = hp;
		this.mp = mp;
		this.sp = sp;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getMp() {
		return mp;
	}

	public void setMp(double mp) {
		this.mp = mp;
	}

	public double getSp() {
		return sp;
	}

	public void setSp(double sp) {
		this.sp = sp;
	}

}
