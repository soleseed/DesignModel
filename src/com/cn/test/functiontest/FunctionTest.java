package com.cn.test.functiontest;

/*函数式接口中可以额外定义多个抽象方法，但这些抽象方法签名必须和Object的public方法一样
接口最终有确定的类实现， 而类的最终父类是Object。 因此函数式接口可以定义Object的public方法。
如以下的接口依然是函数式接口：
@FunctionalInterfacepublic
interface ObjectMethodFunctionalInterface {
void count(int i);
String toString(); //same to Object.toString
int hashCode(); //same to Object.hashCode
boolean equals(Object obj); //same to Object.equals
} 
为什么限定public类型的方法呢？因为接口中定义的方法都是public类型的。 举个例子，下面的接口就不是函数式接口：
interface WrongObjectMethodFunctionalInterface {
void count(int i);
Object clone(); //Object.clone is protected
} 
因为Object.clone方法是protected类型。*/
@FunctionalInterface
public interface FunctionTest {

	void lamda(String a);

	boolean equals(Object o);

}
