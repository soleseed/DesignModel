package com.cn.builder;

public class ConcreteBuilderB extends Builder {

	private Product product = new Product();

	@Override
	public void buildPartA() {
		// TODO Auto-generated method stub
		product.add("partX");
	}

	@Override
	public void buildPartB() {
		// TODO Auto-generated method stub
		product.add("partY");
	}

	@Override
	public void buildPartC() {
		// TODO Auto-generated method stub
		product.add("partZ");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}
