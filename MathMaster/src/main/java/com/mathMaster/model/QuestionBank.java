package com.mathMaster.model;

public class QuestionBank {
	private int questionBankId;
	private String question;
	private Answer correctAnswerId;
	private Subject subjectId;
	private Level levelId;
	
	public QuestionBank() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionBank(int questionBankId, String question, Answer correctAnswerId, Subject subjectId, Level levelId) {
		super();
		this.questionBankId = questionBankId;
		this.question = question;
		this.correctAnswerId = correctAnswerId;
		this.subjectId = subjectId;
		this.levelId = levelId;
	}

	public int getQuestionBankId() {
		return questionBankId;
	}
	
	public void setQuestionBankId(int questionBankId) {
		this.questionBankId = questionBankId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Answer getCorrectAnswerId() {
		return correctAnswerId;
	}
	
	public void setCorrectAnswerId(Answer correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}
	
	public Subject getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}
	
	public Level getLevelId() {
		return levelId;
	}
	
	public void setLevelId(Level levelId) {
		this.levelId = levelId;
	}
	
	@Override
	public String toString() {
		return "QuestionBank [questionBankId=" + questionBankId + ", question=" + question + ", correctAnswerId="
				+ correctAnswerId + ", subjectId=" + subjectId + ", levelId=" + levelId + "]";
	}
}
