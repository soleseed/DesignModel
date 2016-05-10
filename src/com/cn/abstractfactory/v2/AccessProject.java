package com.cn.abstractfactory.v2;

public class AccessProject implements IProject {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert project into Access");
	}

	@Override
	public Project getProject() {
		// TODO Auto-generated method stub
		System.out.println("get project from Access");
		return null;
	}

}
