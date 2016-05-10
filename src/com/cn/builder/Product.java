package com.cn.builder;

import java.util.ArrayList;
import java.util.Collection;

public class Product {
	private Collection<String> parts = new ArrayList<>();

	public void add(String str) {

		parts.add(str);
	}

	public void show() {
		System.out.println("组成部分是：");
		for (String str : parts) {
			System.out.println(str);
		}
	}

}
