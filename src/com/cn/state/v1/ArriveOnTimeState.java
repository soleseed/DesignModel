package com.cn.state.v1;

public class ArriveOnTimeState implements State {

	@Override
	public void doWork(Work w) {
		// TODO Auto-generated method stub
		if (w.getHour() <= 9) {
			System.out.println("早上9点以前到，准备上班。");
		} else {
			w.setS(new LateMorning());
			w.doWork();
		}
	}

}
