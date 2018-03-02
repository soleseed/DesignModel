package com.cn.jvm.test.jvm.dispatch;

public class Dispatch {

	static class QQ {
	};

	static class _360 {
	};

	public static class Father {

		public void choose(QQ qq) {
			System.out.println("father choose qq");
		}

		public void choose(_360 arg) {
			System.out.println("father choose 360");
		}

	}

	public static class Son extends Father {
		public void choose(QQ qq) {
			System.out.println("son choose qq");
		}

		public void choose(_360 arg) {
			System.out.println("son choose 360");
		}
	}

	public static void main(String[] args) {
		System.out.println("abc");
		Father father = new Father();
		Father son = new Son();
		father.choose(new QQ());
		father.choose(new _360());
		son.choose(new QQ());
		son.choose(new _360());
	}

}
