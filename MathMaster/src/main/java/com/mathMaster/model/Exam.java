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
@Table(name = "M2_EXAM")
public class Exam {
	@Id
	@Column(name="EXAM_ID")
	@SequenceGenerator(name="EXAM", sequenceName="EXAM_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="EXAM", strategy=GenerationType.SEQUENCE)
	private int examId;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;

	@OneToMany(mappedBy="exam") 
	private Set<Question> questions = new HashSet<Question>();
		
	@OneToMany(mappedBy="exam")
	private Set<TakenExam> takenExam = new HashSet<TakenExam>();
	
	public Exam() {
		super();
	}

	public Exam(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

	public int getId() {
		return examId;
	}

	public void setId(int id) {
		this.examId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<TakenExam> getTakenExams() {
		return takenExam;
	}

	public void setTakenExams(Set<TakenExam> takenExams) {
		this.takenExam = takenExams;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", name=" + name + ", course=" + course + ", questions=" + questions
				+ ", takenExams=" + takenExam + "]";
	}
}