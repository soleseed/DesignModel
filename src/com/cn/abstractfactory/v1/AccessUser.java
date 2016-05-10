package com.cn.abstractfactory.v1;

public class AccessUser implements IUser {

	@Override
	public void insertUser() {
		// TODO Auto-generated method stub
		System.out.println("insert user into access");
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		System.out.println("get user from Access");
		return null;
	}

}
