package com.cn.builder;

public class ConcreteBuilderA extends Builder {

	private Product product = new Product();

	@Override
	public void buildPartA() {
		// TODO Auto-generated method stub
		product.add("partA");
	}

	@Override
	public void buildPartB() {
		// TODO Auto-generated method stub
		product.add("partB");
	}

	@Override
	public void buildPartC() {
		// TODO Auto-generated method stub
		product.add("partC");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}
