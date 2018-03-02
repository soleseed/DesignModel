package com.cn.jvm.test.jvm.thread;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	static class TimeWaiting implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 该线程在waiting.class实例上等待
	static class Waiting implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class Blocked implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Blocked.class) {
				while (true) {
					try {
						TimeUnit.SECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		// 使用2个blocked线程,一个获得锁,另一个被阻塞
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
	}

}
