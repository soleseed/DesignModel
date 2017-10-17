package com.cn.test.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Cglib implements MethodInterceptor {


	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("111111111");
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("222222222");
		// TODO Auto-generated method stub
		return result;
	}

	public static void main(String[] args) {

		Cglib cglib = new Cglib();
		System.gc();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Programmer.class);
		enhancer.setCallback(cglib);
		Programmer proxy = (Programmer) enhancer.create();
		/* System.out.println(proxy); */
		if (proxy.code().length() > 0) {
			System.out.println(proxy.code());
		}
	}
}
