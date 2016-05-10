package com.cn.memento.v2;

public class Test {
	public static void main(String[] args) {
		GameRole play = new GameRole();
		play.InitState();
		play.show();

		System.out.println("保存状态");
		Save s = new Save();
		s.setRoleStateMemento(play.createMemento());

		play.fight();
		play.show();

		System.out.println("选择存档恢复状态");
		play.setMemento(s.getRoleStateMemento());
		play.show();
	}
}
