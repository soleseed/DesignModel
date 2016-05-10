package com.cn.adapter.v1;

public class Client {
	public static void main(String[] args) {
		Target t = new Adapter();
		t.request();
	}
}
