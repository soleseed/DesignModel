package com.cn.builder;

public class Conductor {

	public Conductor(Builder builder) {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}

}
