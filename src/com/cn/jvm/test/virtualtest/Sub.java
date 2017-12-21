package com.cn.jvm.test.virtualtest;

public class Sub extends Base {
	String str = "Sub string";// 隐藏父类实例字段
	static String static_string = "static Sub string";// 隐藏父类静态字段

	/* 打印this，以父类打印的this作对比 */
	public Sub() {
		System.out.println("Sub.this" + this);
	}

	/*
	 * 测试父类方法中调用被覆盖的init方法,只有虚方法才会被重写，所谓的重写本质上是对虚方法表 中存储的原方法地址的重写、覆盖,从而可以实现多态
	 */
	@Override
	protected void virtual_init() {
		System.out.println("Sub init");
	}

	/*
	 * @Override 静态方法的覆盖不是重写，只能说子类有一个同名的方法隐藏了父类的同名方法
	 * 该隐藏现象不会产生多态效果（当然，因为静态对的根本就不会出现在虚方法表中）
	 */
	protected static void static_init() {
		System.out.println("Sub static init");
	}

	public void show_field() {
		System.out.println(str);// Sub string
		System.out.println(super.str);// Base string，使用super限定访问父类中被隐藏了字段
		System.out.println(static_string);// static Sub string
		System.out.println(Base.static_string);// static base string
	}

	public void virtual_test() {
		/* 访问父类的字段 */
		System.out.println(base_int);
	}

	public static void main(String args[]){
		Sub sub = new Sub();
		sub.virtual_show();
		sub.show_field();
		sub.static_init();// 调用被
		sub.static_init2();

		System.out.println("---------------------------------------");
		Base base = new Sub();
		base.virtual_show();
		
		System.gc();
	}
}
