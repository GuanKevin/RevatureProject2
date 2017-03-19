package com.mathMaster.model;

public class AnsweredQuestion {
	private int answeredQuestionId;
	private QuestionBank questionBankId;
	private Answer chosenAnswerId;
	
	public AnsweredQuestion() {
		// TODO Auto-generated constructor stub
	}
	
	public AnsweredQuestion(int answeredQuestionId, QuestionBank questionBankId, Answer chosenAnswerId) {
		super();
		this.answeredQuestionId = answeredQuestionId;
		this.questionBankId = questionBankId;
		this.chosenAnswerId = chosenAnswerId;
	}

	public int getAnsweredQuestionId() {
		return answeredQuestionId;
	}
	
	public void setAnsweredQuestionId(int answeredQuestionId) {
		this.answeredQuestionId = answeredQuestionId;
	}
	
	public QuestionBank getQuestionBankId() {
		return questionBankId;
	}
	
	public void setQuestionBankId(QuestionBank questionBankId) {
		this.questionBankId = questionBankId;
	}
	
	public Answer getChosenAnswerId() {
		return chosenAnswerId;
	}
	
	public void setChosenAnswerId(Answer chosenAnswerId) {
		this.chosenAnswerId = chosenAnswerId;
	}
	
	@Override
	public String toString() {
		return "AnsweredQuestion [answeredQuestionId=" + answeredQuestionId + ", questionBankId=" + questionBankId
				+ ", chosenAnswerId=" + chosenAnswerId + "]";
	}
}
