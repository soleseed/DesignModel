package com.cn.test.concurrency;

public class ThreadLocalExp {


	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			synchronized (threadLocal) {

				threadLocal.set((int) (Math.random() * 100D));
				System.out.println(Thread.currentThread().getId() + threadLocal.get());
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}

			System.out.println(Thread.currentThread().getId() + threadLocal.get());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();
		System.out.println("1111111");
		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
		System.out.println("22222");
	}

}
