package com.cn.test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlerTest {
	static class A {
		public void println(String s) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws Throwable {
		Object obj = System.currentTimeMillis() % 2 != 0 ? System.out : new A();
		System.out.println(obj.getClass());
		getPrintlnMH(obj).invokeExact("icyfenix");
		
	}

	private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
		MethodType mt = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);

	}

}
