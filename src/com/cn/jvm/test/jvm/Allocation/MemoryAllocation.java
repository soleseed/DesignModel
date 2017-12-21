package com.cn.jvm.test.jvm.Allocation;

public final class MemoryAllocation {
	
	static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2* _1MB];
	
		System.out.println("com/cn/jvm/test/jvm/Allocation/MemoryAllocation".length());
	}

}
