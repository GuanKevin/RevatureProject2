package com.mathMaster.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;


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
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="EXAM_ID")
	private Exam takenExam;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="TIME_TAKEN")
	private Timestamp timeTaken;
	
	/*denise added to mapp to AnsweredQuestions*/
	@OneToMany(mappedBy = "takenExamQuestion", fetch=FetchType.EAGER)
	private Set<AnsweredQuestion> answeredQuestionSet = new HashSet<AnsweredQuestion>();
	
	public TakenExam() {}

	public TakenExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		super();
		this.takenExam = exam;
		this.student = student;
		this.score = score;
		this.timeTaken = timeTaken;
	}

	public int getTakenExamId() {
		return takenExamId;
	}

	public void setTakenExamId(int takenExamId) {
		this.takenExamId = takenExamId;
	}

	public Exam getTakenExam() {
		return takenExam;
	}

	public void setTakenExam(Exam exam) {
		this.takenExam = exam;
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

	public Timestamp getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Timestamp timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Set<AnsweredQuestion> getAnsweredQuestionSet() {
		return answeredQuestionSet;
	}

	public void setAnsweredQuestionSet(Set<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestionSet = answeredQuestions;
	}
}
