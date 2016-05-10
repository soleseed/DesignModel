package com.cn.adapter.v2;

public class Coach {
	public static void main(String[] args) {
		Player p1 = new Forwards("XX");
		p1.attack();

		Player p2 = new Center("ZZ");
		p2.attack();

		Player p3 = new Guards("YY");
		p3.defense();

		Player ym = new Center("YM");
		ym.attack();
		ym.defense();

		Player yms = new AdapterCenter("YM");
		yms.attack();
		yms.defense();
	}
}
