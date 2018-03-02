package com.cn.jvm.test.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

	private static final int THRESHOLD = 2;

	private int start;

	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;

		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			CountTask t1 = new CountTask(start, middle);
			CountTask t2 = new CountTask(middle + 1, end);
			t1.fork();
			t2.fork();
			int r1 = t1.join();
			int r2 = t2.join();
			sum = r1 + r2;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(1, 50);
		assert false;
		Future<Integer> future = forkJoinPool.submit(task);

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
