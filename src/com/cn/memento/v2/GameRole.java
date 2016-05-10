package com.cn.memento.v2;

public class GameRole {

	private double hp;

	private double mp;

	private double sp;

	public RoleStateMemento createMemento() {
		return new RoleStateMemento(hp, mp, sp);
	}

	public void setMemento(RoleStateMemento m) {
		this.hp = m.getHp();
		this.mp = m.getMp();
		this.sp = m.getSp();
	}

	public void InitState() {
		System.out.println("初始状态");
		hp = 100;
		mp = 100;
		sp = 100;
	}

	public void fight() {
		System.out.println("战斗后");
		hp = 0;
		mp = 0;
		sp = 0;
	}

	public void show() {
		System.out.println("状态值：");
		System.out.println("hp = " + this.hp);
		System.out.println("mp = " + this.mp);
		System.out.println("sp = " + this.sp);
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
