package com.cn.memento.v1;

public class Test {
	public static void main(String[] args) {
		Originator o = new Originator();
		o.getInitState();
		Caretaker c = new Caretaker();
		c.setM(o.createMemento());
		System.out.println("初始状态");
		o.show();

		o.fight();
		o.show();

		o.setMemento(c.getM());
		System.out.println("恢复状态");
		o.show();

	}
}
