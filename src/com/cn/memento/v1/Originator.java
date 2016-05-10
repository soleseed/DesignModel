package com.cn.memento.v1;

public class Originator {
	private String state1;

	private String state2;

	public void setMemento(Mementor m) {
		state1 = m.getState1();
		state2 = m.getState2();
	}

	public Mementor createMemento() {
		return new Mementor(state1, state2);
	}

	public void getInitState() {
		state1 = "100";

		state2 = "100";
	}

	public void fight() {
		System.out.println("战斗了");
		state1 = "50";
		state2 = "50";
	}

	public void show() {
		System.out.println("state1 = " + state1 + ", state2 = " + state2);
	}
}
