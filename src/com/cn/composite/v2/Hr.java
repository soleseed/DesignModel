package com.cn.composite.v2;

public class Hr extends Company {

	public Hr(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Company c) {
		// TODO Auto-generated method stub
		System.out.println("cannot add to a leaf");
	}

	@Override
	public void remove(Company c) {
		// TODO Auto-generated method stub
		System.out.println("cannot remove from a leaf");
	}

	@Override
	public void display(int depth) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			sb.append("-");
		}
		sb.append(this.name);
		System.out.println(sb.toString());
	}

	@Override
	public void duty() {
		// TODO Auto-generated method stub
		System.out.println(this.name + "员工招聘培训管理");
	}

}
