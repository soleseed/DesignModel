package com.cn.jvm.test.virtualtest;

public class Base {

	String str = "base string";

	int base_int = 4;

	static String static_string = "static base string";

	public Base() {
		// TODO Auto-generated constructor stub
		System.out.println("base.this" + this);
	}

	public void virtual_show() {
		System.out.println(str);
		System.out.println(static_string);
		virtual_init();
		static_init();
		static_init2();
	}

	/* 这是一个虚方法，会被子类重写覆盖 */
	protected void virtual_init() {
		System.out.println("Base virtual init");
	}

	/* 这是一个静态方法,会被子类隐藏 */
	protected static void static_init() {
		System.out.println("Base static init");
	}

	/* 这是一个静态方法，不会被子类隐藏 */
	protected static void static_init2() {
		System.out.println("Base static init2");
	}


}
