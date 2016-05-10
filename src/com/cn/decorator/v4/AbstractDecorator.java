package com.cn.decorator.v4;

public abstract class AbstractDecorator extends Person {
	protected Person person;

	public void setComponent(Person person) {
		this.person = person;
	}

	public void show() {
		if (person != null) {
			person.show();
		}
	}
}
