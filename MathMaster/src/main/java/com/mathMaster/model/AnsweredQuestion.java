package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author kevgu
 *
 */
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_ANSWERED_QUESTION")
public class AnsweredQuestion {
	@Id
	@Column(name="ANSWERED_QUESTION_ID")
	@SequenceGenerator(name="ANSWERED_QUESTION", sequenceName="ANSWERED_QUESTION_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="ANSWERED_QUESTION", strategy=GenerationType.SEQUENCE)
	private int answeredQuestionId;
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private QuestionBank questionBankId;
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
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
