package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 
 * @author Denise
 *
 */
@Entity
@Table(name="M2_ANSWERED_QUESTION")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class AnsweredQuestion {
	@Id
	@Column(name="ANS_QUES_ID")
	@SequenceGenerator(name="ANS_QUES", sequenceName="ANS_QUES_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="ANS_QUES", strategy=GenerationType.SEQUENCE)
	private int ansQuesId;

	@Column(name = "ANSWER_CHOOSEN")
	private String answerChoosen;
		 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID")
	private Question question;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TAKEN_TEST_ID")
	private TakenTest takenTest;

	
	public AnsweredQuestion() {
		super();
	}

	public AnsweredQuestion(String answerChoosen, Question question, TakenTest takenTest) {
		super();
		this.answerChoosen = answerChoosen;
		this.question = question;
		this.takenTest = takenTest;
	}

	public int getAnsQuesId() {
		return ansQuesId;
	}

	public void setAnsQuesId(int ansQuesId) {
		this.ansQuesId = ansQuesId;
	}

	public String getAnswerChoosen() {
		return answerChoosen;
	}

	public void setAnswerChoosen(String answerChoosen) {
		this.answerChoosen = answerChoosen;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public TakenTest getTakenTest() {
		return takenTest;
	}

	public void setTakenTest(TakenTest takenTest) {
		this.takenTest = takenTest;
	}

	@Override
	public String toString() {
		return "AnsweredQuestions [ansQuesId=" + ansQuesId + ", answerChoosen=" + answerChoosen + ", question="
				+ question + "]";
	}
	
	
	
}
