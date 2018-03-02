package com.cn.jvm.test.synchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinLock implements Lock {

	private final Sync sync = new Sync(2);

	private static class Sync extends AbstractQueuedSynchronizer {

		public Sync(int args) {
			if (args < 0) {
				throw new IllegalArgumentException("args must large than 0");
			}
			setState(args);
		}

		protected int tryAcquireShared(int args) {
			for (;;) {
				int current = getState();
				int newCount = current - args;
				if (newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}

			}
		}

		protected boolean tryReleaseShared(int args) {
			for (;;) {
				int current = getState();
				int newResult = current + args;
				if (compareAndSetState(current, newResult)) {
					return true;
				}
			}
		}

	}

	@Override
	public void lock() {
		sync.acquireShared(1);

	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		sync.releaseShared(1);

	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
