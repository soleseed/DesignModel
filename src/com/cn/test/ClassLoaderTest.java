package com.cn.test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {

		ClassLoader myloader = new ClassLoader() {
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					System.out.println("fileName:" + fileName);
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					// TODO: handle exception
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myloader.loadClass("com.cn.test.ClassLoaderTest").newInstance();
		ClassLoaderTest c = new ClassLoaderTest();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.cn.test.ClassLoaderTest);
		System.out.println(c instanceof com.cn.test.ClassLoaderTest);
	}
}
