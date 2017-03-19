package com.mathMaster.model;

public class Test {
	private int testId;
	private Subject subjectId;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public Test(int testId, Subject subjectId) {
		super();
		this.testId = testId;
		this.subjectId = subjectId;
	}

	public int getTestId() {
		return testId;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public Subject getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", subjectId=" + subjectId + "]";
	}
}
