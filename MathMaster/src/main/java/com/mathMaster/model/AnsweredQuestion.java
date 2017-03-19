package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Table stores all the answer (may or may not be correct) 
 * that is chosen/picked by the student as their solution
 * to the test
 * 
 * @author kevgu
 *
 */
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_ANSWER_QUES")
public class AnsweredQuestion {
	@Id
	@Column(name="ANSWER_QUESTION_ID")
	@SequenceGenerator(name="ANSWER_QUESTION", sequenceName="ANSWER_QUESTION_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="ANSWER_QUESTION", strategy=GenerationType.SEQUENCE)
	private int ansQuesId;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private QuestionBank quesBankId;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@JoinColumn(name="CHOSEN_ANSWER_ID")
	private Answer chosenAnsId;
	
	
	
	public AnsweredQuestion() {}

	public AnsweredQuestion(int ansQuesId, QuestionBank quesBankId, Answer chosenAnsId) {
		super();
		this.ansQuesId = ansQuesId;
		this.quesBankId = quesBankId;
		this.chosenAnsId = chosenAnsId;
	}

	public int getAnsQuesId() {
		return ansQuesId;
	}

	public void setAnsQuesId(int ansQuesId) {
		this.ansQuesId = ansQuesId;
	}

	public QuestionBank getQuesBankId() {
		return quesBankId;
	}

	public void setQuesBankId(QuestionBank quesBankId) {
		this.quesBankId = quesBankId;
	}

	public Answer getChosenAnsId() {
		return chosenAnsId;
	}

	public void setChosenAnsId(Answer chosenAnsId) {
		this.chosenAnsId = chosenAnsId;
	}

	@Override
	public String toString() {
		return "AnsweredQuestion [ansQuesId=" + ansQuesId + ", quesBankId=" + quesBankId + ", chosenAnsId="
				+ chosenAnsId + "]";
	}
}
