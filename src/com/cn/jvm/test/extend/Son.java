package com.cn.jvm.test.extend;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Son extends Father {
	protected static ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<String>();
}
