package com.cn.composite.v2;

import java.util.ArrayList;
import java.util.Collection;

public class ConcreteCompany extends Company {

	private Collection<Company> companies = new ArrayList<Company>();

	public ConcreteCompany(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Company c) {
		// TODO Auto-generated method stub
		companies.add(c);
	}

	@Override
	public void remove(Company c) {
		// TODO Auto-generated method stub
		companies.remove(c);
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
		for (Company c : companies) {
			c.display(depth + 2);
		}
	}

	@Override
	public void duty() {
		// TODO Auto-generated method stub
		for (Company c : companies) {
			c.duty();
		}
	}

	public static void main(String[] args) {
		ConcreteCompany root = new ConcreteCompany("北京总公司");
		root.add(new Hr("总公司人力资源部"));
		root.add(new Finace("总公司财务部"));

		ConcreteCompany com = new ConcreteCompany("上海华东分公司");
		com.add(new Hr("华东分公司人力资源部"));
		com.add(new Finace("华东分公司财务部"));
		root.add(com);

		ConcreteCompany comp1 = new ConcreteCompany("南京办事处");
		comp1.add(new Hr("南京办事处人力资源部"));
		comp1.add(new Finace("南京办事处财务部"));
		com.add(comp1);

		ConcreteCompany comp2 = new ConcreteCompany("杭州办事处");
		comp2.add(new Hr("杭州办事处人力资源部"));
		comp2.add(new Finace("杭州办事处财务部"));
		com.add(comp2);

		root.display(1);

		root.duty();
	}

}
