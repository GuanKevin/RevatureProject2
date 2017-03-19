package com.mathMaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Pier Yos
 */
@Entity
@Table(name = "M2_TAKEN_TEST")
public class TakenTest {
	@Id
	@Column(name = "TAKEN_TEST_ID")
	@SequenceGenerator(name = "takenTest", sequenceName = "TAKEN_TEST_PK_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "takenTest", strategy = GenerationType.SEQUENCE)
	private int takenTestId;

	@OneToOne
	@JoinColumn(name = "STUDENT_COURSE_ID")
	private StudentCourse studentCourse;

	@OneToOne
	@JoinColumn(name = "TEST_ID")
	private Test test;

	@Column(name = "SCORE")
	private float score;

	@ManyToMany
	@JoinTable(name = "TAKEN_TEST_ANSWERED_QUESTION")
	//aqlist = answeredQuestionList
	private List<AnsweredQuestion> aqList = new ArrayList<AnsweredQuestion>();

	public TakenTest() {
		super();
	}

	public TakenTest(Test test, int score) {
		super();
		this.test = test;
		this.score = score;
	}

	public int getTakenTestId() {
		return takenTestId;
	}

	public void setTakenTestId(int takenTestId) {
		this.takenTestId = takenTestId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}

	public float getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "TakenTest [takenTestId=" + takenTestId + ", studentCourse=" + studentCourse + ", test=" + test
				+ ", score=" + score + ", aqList=" + aqList + "]";
	}
}
