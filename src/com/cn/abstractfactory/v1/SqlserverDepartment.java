package com.cn.abstractfactory.v1;

public class SqlserverDepartment implements IDepartment {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert department into sql server");
	}

	@Override
	public Department getDepartment() {
		// TODO Auto-generated method stub
		System.out.println("get department from sqlserver");
		return null;
	}

}
