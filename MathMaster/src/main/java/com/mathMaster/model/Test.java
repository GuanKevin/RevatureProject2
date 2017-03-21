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
@Table(name = "M2_TEST")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class Test {
	@Id
	@Column(name="TEST_ID")
	@SequenceGenerator(name="TEST", sequenceName="TEST_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="TEST", strategy=GenerationType.SEQUENCE)
	private int testId;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;

	@OneToMany(mappedBy="test") 
	private Set<Question> questionSet = new HashSet<Question>();
		
	@OneToMany(mappedBy="test")
	private Set<TakenTest> takenTestSet = new HashSet<TakenTest>();
	
	public Test() {
		super();
	}

	public Test(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

	public int getId() {
		return testId;
	}

	public void setId(int id) {
		this.testId = id;
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

	@Override
	public String toString() {
		return "Test [id=" + testId + ", name=" + name + ", course=" + course + "]";
	}
}