package com.cn.abstractfactory.v2;

public class AccessDepartment implements IDepartment {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert department into Access");
	}

	@Override
	public Department getDepartment() {
		// TODO Auto-generated method stub
		System.out.println("get department from Access");
		return null;
	}

}
