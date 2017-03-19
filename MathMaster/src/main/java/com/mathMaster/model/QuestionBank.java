package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Daniel Liu
 *
 */
@Entity
@Table(name="M2_QUESTION_BANK")
public class QuestionBank {
	@Id
	@Column(name="QUESTION_BANK_ID")
	@SequenceGenerator(name="question_bank", sequenceName="QUESTION_BANK_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="question_bank", strategy=GenerationType.SEQUENCE)
	private int questionBankId;
	@Column(name="QUESTION", unique=true)
	private String question;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@JoinColumn(name="CORRECT_ANSWER_ID")
	private Answer correctAnswerId;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@JoinColumn(name="SUBJECT_ID")
	private Subject subjectId;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@JoinColumn(name="LEVEL_ID")
	private Level levelId;
	
	public QuestionBank() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionBank(String question, Answer correctAnswerId, Subject subjectId, Level levelId) {
		super();
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
