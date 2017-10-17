package com.cn.test.functiontest;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FunctionTest f = a -> {
			System.out.println("这是lamda表达式:" + "参数" + a);
		};
	}
}
