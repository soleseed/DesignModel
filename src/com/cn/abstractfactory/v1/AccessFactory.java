package com.cn.abstractfactory.v1;

public class AccessFactory implements IFactory {

	@Override
	public IUser createUser() {
		// TODO Auto-generated method stub
		return new AccessUser();
	}

	@Override
	public IDepartment createDepartment() {
		// TODO Auto-generated method stub
		return new AccessDepartment();
	}

}
