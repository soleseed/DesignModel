package com.cn.jvm.test.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class DynamicProxyTest {
	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {

		List<Integer> list = Arrays.asList(1, 3, 4, 6);

		@Override
		public void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("hello world");
		}

	}

	static class DynamicProxy implements InvocationHandler {

		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
					originalObj.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}

	}

	public static void main(String[] args) {
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();

		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		// 比较自动调用了integer.valueOf()拆箱方法, Integer
		// 数据类型会缓存-127~128之间的数据,此范围内数值一样的Integer都是同一个引用
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));
	}
}
