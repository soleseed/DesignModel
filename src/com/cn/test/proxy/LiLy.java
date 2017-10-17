package com.cn.test.proxy;

public class LiLy implements Human {

	@Override
	public String sayHello(String s) {
		System.out.println("Lily很害羞，sayHello:" + s);
		return "ssssss";
	}

	@Override
	public void sendPresent() {
		System.out.println("Lily很害羞，sendPresent");
	}

}
