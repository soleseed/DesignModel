package com.cn.proxy;

public class PursuitProxy implements IGiveGift {

	private Pursuit pursuit;

	public PursuitProxy(Pursuit pursuit) {
		this.pursuit = pursuit;
	}

	@Override
	public void giveFlower() {
		// TODO Auto-generated method stub
		pursuit.giveFlower();
	}

	@Override
	public void giveDolls() {
		// TODO Auto-generated method stub
		pursuit.giveDolls();
	}

	@Override
	public void giveChocolate() {
		// TODO Auto-generated method stub
		pursuit.giveChocolate();
	}

	public static void main(String[] args) {
		PursuitProxy proxy = new PursuitProxy(new Pursuit());
		proxy.giveFlower();
		proxy.giveDolls();
		proxy.giveChocolate();
	}
}
