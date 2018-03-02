package com.cn.jvm.test.jvm.dispatch;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class TestMethodHandle {

	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}

	class Father extends GrandFather {

		void thinking() {
			System.out.println("i am father");
		}
	}

	class Son extends Father {
		void thinking() {
			try {
				MethodType mt = MethodType.methodType(void.class);
				MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, Son.class);
				mh.invoke(this);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		(new TestMethodHandle().new Son()).thinking();
	}
}
