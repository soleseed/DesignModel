package com.cn.jvm.test.synchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TestTwinLock {
	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new TwinLock();
		class worker extends Thread {
			public void run() {
				while (true) {
					try {
						lock.lock();
						TimeUnit.SECONDS.sleep(1);
						System.out.println(Thread.currentThread().getName());
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock.unlock();
					}
				}
			}

		}

		for (int i = 0; i < 10; i++) {
			worker worker = new worker();
			worker.setDaemon(true);
			worker.start();
		}

		for (int i = 0; i < 10; i++) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
		}
	}
}
