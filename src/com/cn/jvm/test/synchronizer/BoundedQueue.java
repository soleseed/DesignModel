package com.cn.jvm.test.synchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {

	private Object[] items;

	private int addIndex;

	private int removeIndex;

	private int count;

	private final Lock lock = new ReentrantLock();

	private final Condition notEmpty = lock.newCondition();

	private final Condition notFull = lock.newCondition();

	public BoundedQueue(int size) {
		items = new Object[size];
	}

	public void add(T t) throws InterruptedException {
		try {
			lock.lock();
			while (count == items.length) {
				System.out.println("队列已满正在等待notFull信号");
				notFull.await();
			}
			items[addIndex] = t;
			if (++addIndex == items.length) {
				addIndex = 0;
			}
			count++;
			System.out.println(t + "加入,发出notEmpty信号");
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public T remove() throws InterruptedException {
		try {
			lock.lock();
			while (count == 0) {
				System.out.println("队列已空正在等待notEmpty信号");
				notEmpty.await();
			}
			Object o = items[removeIndex];
			if (++removeIndex == items.length) {
				removeIndex = 0;
			}
			--count;
			System.out.println(o + "移除,发出notFull信号");
			notFull.signal();
			return (T) o;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		BoundedQueue<Integer> strQueue = new BoundedQueue<Integer>(3);
		new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while (count < 10) {
					try {
						strQueue.add(count++);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						strQueue.remove();
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

	}
}
