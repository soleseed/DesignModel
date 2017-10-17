package com.cn.test.excutor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorCase {

	public static ExecutorService executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			executor.execute(new ExcutorCase().new Task());
		}
		Thread.sleep(10000);
		executor.shutdown();
		if (executor.isShutdown()) {
			System.out.println("shut down");
			return;
		} else {
			System.out.println("go on");
		}
	}

	class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName());
			System.out.println("开启：" + new Date());
		}
	}
}
