package com.cn.observer.v1;

public class Test {
	public static void main(String[] args) {
		AbstractSubject s = new ConcreteSubject();

		s.attach(new ConcreteObserver(s, "DD"));
		s.attach(new ConcreteObserver(s, "ZZ"));
		s.attach(new ConcreteObserver(s, "XX"));

		s.setSubjectState("老板回来了");
		s.notifyObservers();
	}
}
