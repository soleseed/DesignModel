package com.cn.abstractfactory.v2;

public class DataAccess {
	public static final String DB_SQLSERVER_USER = "com.cn.abstractfactory.v2.SqlserverUser";

	public static final String DB_ACCESS_USER = "com.cn.abstractfactory.v2.AccessUser";

	public static final String DB_SQLSERVER_DEPARTMENT = "com.cn.abstractfactory.v2.SqlserverDepartment";

	public static final String DB_ACCESS_DEPARTMENT = "com.cn.abstractfactory.v2.AccessDepartment";

	public static final String DB_SQLSERVER_PROJECT = "com.cn.abstractfactory.v2.SqlserverProject";

	public static final String DB_ACCESS_PROJECT = "com.cn.abstractfactory.v2.AccessProject";

	public static IUser createUser(String str) {
		IUser result = null;
		Class<IUser> clazz;
		try {
			clazz = (Class<IUser>) Class.forName(str);
			result = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static IDepartment createDepartment(String str) {
		IDepartment result = null;
		Class<IDepartment> clazz;
		try {
			clazz = (Class<IDepartment>) Class.forName(str);
			result = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static IProject createProject(String str) {
		IProject result = null;

		try {
			Class clazz = Class.forName(str);
			result = (IProject) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		IUser user = DataAccess.createUser(DB_SQLSERVER_USER);
		user.insertUser();
		user.getUser();

		IDepartment department = DataAccess.createDepartment(DB_ACCESS_DEPARTMENT);
		department.insert();
		department.getDepartment();

		IProject project = DataAccess.createProject(DB_SQLSERVER_PROJECT);
		project.insert();
		project.getProject();
	}
}
