package com.cn.jvm.test.jvm.clazz;

public class Clazz {
	
	public static  volatile transient String str1 = "abc";
	
	
	public   volatile transient String str2 = str1;
	
	int a = 1;
	
	int b =2;
	
//	static{
//		System.out.println("开始类构造器");
//	}
//	
//	public Clazz(){
//		System.out.println("实例构造器");
//	}
//	
	
	
	public int test(String a){
		System.out.println(this.a+b);
		System.out.println(str1);
		System.out.println(str2);
		
		return this.a+b;
	}
	
	public static void test1(String a){
		System.out.println(str1);
		
		//return null;
	}
	
	public static void main(String[] args) {
		
	}
	

	public  class Notinitailization{
		//public static String str = "abcd";
	}
}


