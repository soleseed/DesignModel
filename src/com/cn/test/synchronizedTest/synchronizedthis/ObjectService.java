package com.cn.test.synchronizedTest.synchronizedthis;

public class ObjectService {
	

	private static Object lock = new Object();

	String lockStr = new String();

	public ObjectService() {
		// TODO Auto-generated constructor stub
	}

	public void serviceMethodA() throws InterruptedException {
		synchronized (ObjectService.class) {
			System.out.println("A  begin time=" + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("A  end time=" + System.currentTimeMillis());
		}
	}

	public static synchronized void serviceMethodB() throws InterruptedException {
		// synchronized (lockStr) {
			System.out.println("B  begin time=" + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("B  end time=" + System.currentTimeMillis());
		// }
	}

	public static void main(String[] args) throws InterruptedException {
		ObjectService o = new ObjectService();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// o.serviceMethodA();
					new ObjectService().serviceMethodA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// o.serviceMethodB();
					ObjectService.serviceMethodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		Runnable runnable = () -> {
			try {
				System.out.println("Foo" + Thread.currentThread().getName());
				Thread.sleep(1000);
				System.out.println("Bar" + Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		new Thread(runnable).start();

	}
}
