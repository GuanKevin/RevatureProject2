package com.mathMaster.model;

public class TakenTest {
	private int takenTestId;
	private Test testId;
	private int score;
	
	public TakenTest() {
		// TODO Auto-generated constructor stub
	}
	
	public TakenTest(int takenTestId, Test testId, int score) {
		super();
		this.takenTestId = takenTestId;
		this.testId = testId;
		this.score = score;
	}

	public int getTakenTestId() {
		return takenTestId;
	}
	
	public void setTakenTestId(int takenTestId) {
		this.takenTestId = takenTestId;
	}
	
	public Test getTestId() {
		return testId;
	}
	
	public void setTestId(Test testId) {
		this.testId = testId;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "TakenTest [takenTestId=" + takenTestId + ", testId=" + testId + ", score=" + score + "]";
	}
}
