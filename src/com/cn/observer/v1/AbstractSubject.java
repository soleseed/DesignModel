package com.cn.observer.v1;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractSubject {

	private Collection<IObserver> observers = new ArrayList<IObserver>();

	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}

	public void attach(IObserver observer) {
		observers.add(observer);
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
