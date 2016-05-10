package com.cn.observer.v1;

public class ConcreteObserver implements IObserver {

	private String name;

	private String observerState;

	private AbstractSubject subject;

	public ConcreteObserver(AbstractSubject subject, String name) {
		this.name = name;

		this.subject = subject;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		observerState = subject.getSubjectState();
		System.out.println("观察者" + name + "状态是" + observerState);
	}

}
