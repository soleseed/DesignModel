package com.cn.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object target;

	public ProxyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("111");
		Object ret = method.invoke(target, args);
		System.out.println(ret);
		return ret;
	}

	public static void main(String[] args) {
		Human proxyLily = (Human) Proxy.newProxyInstance(LiLy.class.getClassLoader(), LiLy.class.getInterfaces(),
				new ProxyHandler(new LiLy()));
		proxyLily.sayHello("123123");
	}

}
