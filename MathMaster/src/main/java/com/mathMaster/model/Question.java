package com.mathMaster.model;

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
 * Denise
 */
@Entity
@Table(name="M2_QUESTION")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class Question {
	@Id
	@Column(name="QUESTION_ID")
	@SequenceGenerator(name="QUESTION", sequenceName="QUESTION_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="QUESTION", strategy=GenerationType.SEQUENCE)
	private int questionId;

	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private Test test;

	@Column (name = "LEVEL")
	private int level;
	
	@Column (name = "QUESTION")
	private String question; 
	
	@Column (name = "ANSWER")
	private String answer;
	
	@Column (name = "CHOICE_ONE")
	private String choiceOne;
	
	@Column (name = "CHOICE_TWO")
	private String choiceTwo;
	
	@Column (name = "CHOICE_THREE")
	private String choiceThree;
	
	public Question() {}
	
	public Question(Test test, int level, String question, String answer, String choiceOne,
			String choiceTwo, String choiceThree) {
		super();
		this.test = test;
		this.level = level;
		this.question = question;
		this.answer = answer;
		this.choiceOne = choiceOne;
		this.choiceTwo = choiceTwo;
		this.choiceThree = choiceThree;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getChoiceOne() {
		return choiceOne;
	}

	public void setChoiceOne(String choiceOne) {
		this.choiceOne = choiceOne;
	}

	public String getChoiceTwo() {
		return choiceTwo;
	}

	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}

	public String getChoiceThree() {
		return choiceThree;
	}

	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", level=" + level + ", question=" + question + ", answer="
				+ answer + ", choiceOne=" + choiceOne + ", choiceTwo=" + choiceTwo + ", choiceThree=" + choiceThree
				+ "]";
	}
	
	
}
