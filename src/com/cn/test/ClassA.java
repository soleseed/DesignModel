package com.cn.test;

import java.util.ArrayList;
import java.util.List;

public class ClassA {

	public int a = 0;

	public List<String> list = new ArrayList<String>();

	public void print() {
		for (String str : this.list) {
			System.out.println(str + "/n");
			System.out.println(a);
		}
	}
}
