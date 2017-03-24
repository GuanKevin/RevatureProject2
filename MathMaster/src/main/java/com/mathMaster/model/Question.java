package com.mathMaster.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Denise
 *
 */

@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_QUESTION")
public class Question {
	@Id
	@Column(name="QUESTION_ID")
	@SequenceGenerator(name="QUESTION", sequenceName="QUESTION_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="QUESTION", strategy=GenerationType.SEQUENCE)
	private int questionId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EXAM_ID")
	private Exam examQuestion;
	// level is a reserved word in db
	@Column (name = "LVL")
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
	
	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	private Set<AnsweredQuestion> answeredQuestions = new HashSet<AnsweredQuestion>();
	
	
	public Question() {
		super();
	}
	
	public Question(Exam exam, int level, String question, String answer, String choiceOne,
			String choiceTwo, String choiceThree) {
		super();
		this.examQuestion = exam;
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

	public Exam getExamQuestion() {
		return examQuestion;
	}

	public void setExamQuestion(Exam exam) {
		this.examQuestion = exam;
	}

	public Set<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(Set<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", examQuestion=" + examQuestion + ", level=" + level
				+ ", question=" + question + ", answer=" + answer + ", choiceOne=" + choiceOne + ", choiceTwo="
				+ choiceTwo + ", choiceThree=" + choiceThree + "]";
	}


	
}
