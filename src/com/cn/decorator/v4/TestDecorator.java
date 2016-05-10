package com.cn.decorator.v4;

public class TestDecorator {
	public static void main(String[] args) {
		Person p = new Teacher("xx");
		Person pp = new Student("YY");

		Reading read = new Reading();
		Teaching teach = new Teaching();
		AtendClass atendClass = new AtendClass();

		teach.setComponent(p);
		atendClass.setComponent(teach);
		atendClass.show();

		read.setComponent(pp);
		atendClass.setComponent(read);
		atendClass.show();
	}
}
