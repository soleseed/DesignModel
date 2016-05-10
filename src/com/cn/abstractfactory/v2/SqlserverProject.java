package com.cn.abstractfactory.v2;

public class SqlserverProject implements IProject {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert project into sqlserver");
	}

	@Override
	public Project getProject() {
		// TODO Auto-generated method stub
		System.out.println("get project from sqlserver");
		return null;
	}

}
