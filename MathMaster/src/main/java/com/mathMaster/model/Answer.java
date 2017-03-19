package com.mathMaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Table stores all the correct answers to questions from Question Bank class
 * 
 * @author kevgu
 *
 */
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_ANSWER")
public class Answer {
	@Id
	@Column(name="ANSWER_ID")
	@SequenceGenerator(name="ANSWER", sequenceName="ANSWER_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="ANSWER", strategy=GenerationType.SEQUENCE)
	private int answerId;
	
	@Column(name = "ANSWER", unique=true)
	private String answer;
	
	@ManyToMany(mappedBy="answerList")
	private List<Question> questionList = new ArrayList<Question>();
	
	public Answer() {}
	
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}

	public int getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + "]";
	}
}
