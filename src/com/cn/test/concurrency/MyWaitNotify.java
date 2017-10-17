package com.cn.test.concurrency;

public class MyWaitNotify implements Runnable {

	public Object lock;

	private boolean isWait;

	boolean wasSignalled = false;

	public MyWaitNotify(boolean isWait, Object obj) {
		this.isWait = isWait;
		this.lock = obj;
	}

	public void doWait() {
		synchronized (lock) {
			while (!wasSignalled) {
				try {
					System.out.println("begin wait***********");
					lock.wait();
					System.out.println("end wait***********");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			wasSignalled = false;
		}
	}

	public void doNotify() {
		synchronized (lock) {
			wasSignalled = true;
			System.out.println("begin notify***********");
			lock.notify();
			System.out.println("end notify***********");
		}
	}

	@Override
	public void run() {
		if (isWait) {
			doWait();
		} else {
			doNotify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyWaitNotify my = new MyWaitNotify(true, new Object());
		Thread.sleep(3000);
		new Thread(new Runnable() {
			@Override
			public void run() {
				my.doWait();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					my.doNotify();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

	}
}
