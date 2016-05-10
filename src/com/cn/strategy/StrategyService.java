package com.cn.strategy;

public class StrategyService {
	private IStrategy strategy;

	public StrategyService(IStrategy strategy) {

		this.strategy = strategy;
	}

	public void strategyMethod() {
		strategy.method();
	}

	public static void main(String[] args) {
		StrategyService s1 = new StrategyService(new ConcreteStrategyA());
		s1.strategyMethod();

		StrategyService s2 = new StrategyService(new ConcreteStrategyB());
		s2.strategyMethod();

		StrategyService s3 = new StrategyService(new ConcreteStrategyC());
		s3.strategyMethod();
	}
}
