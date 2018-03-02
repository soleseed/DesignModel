package com.cn.jvm.test.jvm.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadExecutor {

	static class SingleThreadTask implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i = 1;
			while (i <= 100) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				i++;
				if (i > 50) {
					break;
					// System.out.println("exception happens");
					// String s = null;
					// System.out.println(s.length());
				}
			}
			System.out.println("over");
		}
	}

	public static void main(String[] args) {
		String s = null;
		System.out.println(s.length());
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(new SingleThreadTask());
		es.submit(new SingleThreadTask());
	}
}
