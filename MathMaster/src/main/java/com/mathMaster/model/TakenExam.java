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


@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_TAKEN_EXAM")
public class TakenExam {
	@Id
	@Column(name="TAKEN_EXAM_ID")
	@SequenceGenerator(name="TAKEN_EXAM", sequenceName="TAKEN_EXAM_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="TAKEN_EXAM", strategy=GenerationType.SEQUENCE)
	private int takenExamId;
	
	@ManyToOne
	@JoinColumn(name="EXAM_ID")
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="TIME_TAKEN")
	private int timeTaken;
	
	/*denise added to mapp to AnsweredQuestions*/
	@OneToMany(mappedBy = "takenExam")
	private Set<AnsweredQuestion> answeredQuestions = new HashSet<AnsweredQuestion>();
	
	public TakenExam() {}

	public TakenExam(Exam exam, Student student, int score, int timeTaken) {
		super();
		this.exam = exam;
		this.student = student;
		this.score = score;
		this.timeTaken = timeTaken;
	}

	public int getTakenTestId() {
		return takenExamId;
	}

	public void setTakenTestId(int takenExamId) {
		this.takenExamId = takenExamId;
	}

	public Exam getTest() {
		return exam;
	}

	public void setTest(Exam exam) {
		this.exam = exam;
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

	public Set<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(Set<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	@Override
	public String toString() {
		return "TakenExam [takenExamId=" + takenExamId + ", exam=" + exam + ", student=" + student + ", score=" + score
				+ ", timeTaken=" + timeTaken + ", answeredQuestions=" + answeredQuestions + "]";
	}
}
