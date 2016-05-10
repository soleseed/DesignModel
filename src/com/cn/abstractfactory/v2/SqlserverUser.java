package com.cn.abstractfactory.v2;

public class SqlserverUser implements IUser {

	@Override
	public void insertUser() {
		// TODO Auto-generated method stub
		System.out.println("insert user into sql server");
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		System.out.println("get user from sql server");
		return null;
	}

}
