package com.cn.templateMethod.v1;

public class TestAnswers {
	public static void main(String[] args) {
		AbstractTestPaper studentA = new StudentA();
		studentA.testQuestions1();
		studentA.testQuestions2();
		studentA.testQuestions3();

		AbstractTestPaper studentB = new StudentB();
		studentB.testQuestions1();
		studentB.testQuestions2();
		studentB.testQuestions3();
	}
}
