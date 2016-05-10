package com.cn.templateMethod.v2;

public abstract class AbstractClass {

	public void templateMethod() {

		primitiveOperation1();
		primitiveOperation2();
		System.out.println("模板方法");
	}

	public abstract void primitiveOperation1();

	public abstract void primitiveOperation2();

}
