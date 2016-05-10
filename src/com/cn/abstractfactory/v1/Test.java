package com.cn.abstractfactory.v1;

public class Test {

	public static void main(String[] args) {

		IFactory sqlserverUserFactory = new SqlserverFactory();
		IFactory accessUserFactory = new AccessFactory();

		IUser sqlUser = sqlserverUserFactory.createUser();
		sqlUser.getUser();
		sqlUser.insertUser();

		IUser accessUser = accessUserFactory.createUser();
		accessUser.getUser();
		accessUser.insertUser();

		IDepartment department = sqlserverUserFactory.createDepartment();
		department.getDepartment();
		department.insert();

	}

}
