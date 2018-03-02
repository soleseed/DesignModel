package com.cn.jvm.test.jvm.thread.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
		for (ThreadInfo t : threadInfos) {
			System.out.println(t.getThreadId() + t.getThreadName());
		}
	}
}
