package com.mathMaster.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name="M2_TAKEN_TEST")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class TakenTest {
	@Id
	@Column(name="TAKEN_TEST_ID")
	@SequenceGenerator(name="TAKEN_TEST", sequenceName="TAKEN_TEST_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="TAKEN_TEST", strategy=GenerationType.SEQUENCE)
	private int takenTestId;
	
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="TIME_TAKEN")
	private int timeTaken;
	
	/*denise added to mapp to AnsweredQuestions*/
	@OneToMany(mappedBy = "takenTest")
	private Set<AnsweredQuestions> answeredQuestions = new HashSet<AnsweredQuestions>();
	
	public TakenTest() {}

	public TakenTest(Test test, Student student, int score, int timeTaken) {
		super();
		this.test = test;

		this.student = student;
		this.score = score;
		this.timeTaken = timeTaken;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Set<AnsweredQuestions> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(Set<AnsweredQuestions> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	@Override
	public String toString() {
		return "TakenTest [takenTestId=" + takenTestId + ", test=" + test + ", student=" + student + ", score="
				+ score + ", timeTaken=" + timeTaken + "]";
	}
}
