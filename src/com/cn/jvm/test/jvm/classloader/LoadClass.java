package com.cn.jvm.test.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

public class LoadClass {

	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (null == is) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ClassNotFoundException(name);
				}

			}

		};
		Class oClass = myLoader.loadClass("com.cn.jvm.test.jvm.classloader.LoadClass");
		Object object = oClass.newInstance();
		System.out.println(object.getClass());
		System.out.println(object instanceof com.cn.jvm.test.jvm.classloader.LoadClass);
		Class clazz = Class.forName("com.cn.jvm.test.jvm.classloader.LoadClass");
		Object cObject = clazz.newInstance();
		System.out.println(clazz);
		System.out.println(clazz.isInstance(object));
		System.out.println(clazz.isAssignableFrom(Integer.class));
		System.out.println(oClass.getClassLoader());
		System.out.println(clazz.getClassLoader());
		System.out.println(clazz.equals(LoadClass.class));
		System.out.println(LoadClass.class.getClassLoader());
		System.out.println(Integer.class.isAssignableFrom(Character.class));
	}

}
