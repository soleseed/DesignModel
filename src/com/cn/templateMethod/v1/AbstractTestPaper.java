package com.cn.templateMethod.v1;

public abstract class AbstractTestPaper {
	public void testQuestions1() {
		System.out.println("题目1:---------");
		System.out.println("答案是： " + answer1());
	}

	public void testQuestions2() {
		System.out.println("题目2:---------");
		System.out.println("答案是： " + answer2());
	}

	public void testQuestions3() {
		System.out.println("题目3:---------");
		System.out.println("答案是： " + answer3());

	}

	public abstract String answer1();

	public abstract String answer2();

	public abstract String answer3();
}
