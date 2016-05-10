package com.cn.state.v1;

public class Work {

	private State s;

	private double hour;

	public Work() {
		s = new ArriveOnTimeState();
	}

	public void doWork() {
		s.doWork(this);
	}

	public State getS() {
		return s;
	}

	public void setS(State s) {
		this.s = s;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

}
