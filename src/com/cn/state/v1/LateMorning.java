package com.cn.state.v1;

public class LateMorning implements State {

	@Override
	public void doWork(Work w) {
		// TODO Auto-generated method stub
		if (w.getHour() <= 9.5) {
			System.out.println("上午迟到，开始工作");
		} else {

		}
	}

}
