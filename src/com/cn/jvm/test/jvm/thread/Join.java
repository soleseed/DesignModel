package com.cn.jvm.test.jvm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Join {

	public static void main(String[] args) {
		ExecutorService es = Executors.newScheduledThreadPool(1);
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			previous = thread;
			thread.start();
			// 线程启动准则
		}

	}

	static class Domino implements Runnable {

		private Thread thread;

		public Domino(Thread thread) {
			// TODO Auto-generated constructor stub
			this.thread = thread;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				// TimeUnit.SECONDS.sleep(5);
				System.out.println(Thread.currentThread().getName() + "等待前驱线程" + thread.getName());
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " terminated");
		}

		// 2等待前驱线程1
		// 0等待前驱线程main
		// 0 terminated
		// 4等待前驱线程3
		// 5等待前驱线程4
		// 8等待前驱线程7
		// 1等待前驱线程0
		// 3等待前驱线程2
		// 9等待前驱线程8
		// 7等待前驱线程6
		// 1 terminated
		// 6等待前驱线程5
		// 2 terminated
		// 3 terminated
		// 4 terminated
		// 5 terminated
		// 6 terminated
		// 7 terminated
		// 8 terminated
		// 9 terminated
	}
}
