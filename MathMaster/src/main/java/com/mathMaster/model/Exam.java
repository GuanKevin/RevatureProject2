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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIgnoreProperties({"course", "takenExamSet"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name = "M2_EXAM")
public class Exam {
	@Id
	@Column(name="EXAM_ID")
	@SequenceGenerator(name="EXAM", sequenceName="EXAM_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="EXAM", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EXAM_START")
	private Timestamp start;
	
	@Column(name="EXAM_END")
	private Timestamp end;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;

	@OneToMany(mappedBy="examQuestion", fetch=FetchType.EAGER, cascade = CascadeType.ALL) 
	private Set<Question> questionSet = new HashSet<Question>();
		
	@OneToMany(mappedBy="takenExam", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<TakenExam> takenExamSet = new HashSet<TakenExam>();
	
	public Exam() {
		super();
	}

	public Exam(String name, Timestamp start, Timestamp end) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public Set<TakenExam> getTakenExamSet() {
		return takenExamSet;
	}

	public void setTakenExamSet(Set<TakenExam> takenExamSet) {
		this.takenExamSet = takenExamSet;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", start=" + start + ", end=" + end + ", course=" + course
				+ ", takenExam=" + takenExamSet + "]";
	}
}