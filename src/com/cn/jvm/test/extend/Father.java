package com.cn.jvm.test.extend;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Father {

	protected static ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<String>();

	protected void add(String a) {
		this.list.add(a);
	}

	protected void remove(String a) {
		this.list.remove(a);
	}

	protected void print() {
		this.list.stream().forEach(a -> {
			System.out.println(a);
		});
	}

	public static void main(String[] args) {
		Son s = new Son();
		Daughter d = new Daughter();
		s.add("sa");
		s.print();
		System.out.println(s.list);
		d.add("da");
		d.print();
		System.out.println(d.list);
	}
}
