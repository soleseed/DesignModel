package com.cn.jvm.test.jvm.thread.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

	// 最大工作者数量
	private static final int MAX_WORKER_NUMBERS = 10;

	// 默认工作者数量
	private static final int DEFAULT_WORKERS_NUMBERS = 5;

	// 最小工作者数量
	private static final int MIN_WORKERS_NUMBERS = 1;

	// 工作列表,提交的工作将会加入列表总
	private final LinkedList<Job> jobs = new LinkedList<Job>();

	// 工作者列表
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

	// 工作者线程的数量
	private int workerNum = DEFAULT_WORKERS_NUMBERS;

	// 线程编号生成
	private AtomicLong threadNum = new AtomicLong();

	public DefaultThreadPool() {
		initWorkes(DEFAULT_WORKERS_NUMBERS);
	}

	public DefaultThreadPool(int num) {
		if (num > MAX_WORKER_NUMBERS) {
			num = MAX_WORKER_NUMBERS;
		} else if (num < MIN_WORKERS_NUMBERS) {
			num = MIN_WORKERS_NUMBERS;
		}
		initWorkes(num);
	}

	private void initWorkes(int num) {
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker, "ThreadPool-worker-" + threadNum.incrementAndGet());
			thread.start();
		}
	}

	@Override
	public void execute(Job job) {
		// TODO Auto-generated method stub
		if (job != null) {
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		for (Worker worker : workers) {
			worker.shutdown();
		}
	}

	@Override
	public void addWorkers(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if (num + this.workerNum > MAX_WORKER_NUMBERS) {
				num = MAX_WORKER_NUMBERS - this.workerNum;
			}
			initWorkes(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorker(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if (num > this.workerNum) {
				throw new IllegalArgumentException("beyond worknum");
			}
			int count = 0;
			while (count < num) {
				Worker worker = workers.get(count);
				if (workers.remove(worker)) {
					worker.shutdown();
					count++;
				}
			}
			this.workerNum -= count;
		}
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return jobs.size();
	}

	class Worker implements Runnable {

		// 是否工作FLAG
		private volatile boolean running = true;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (running) {
				Job job = null;
				synchronized (jobs) {
					while (jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							Thread.currentThread().interrupt();
							return;
						}

					}
					job = jobs.removeFirst();
				}
				if (job != null) {
					job.run();
				}
			}
		}

		public void shutdown() {
			this.running = false;
		}

	}
}
