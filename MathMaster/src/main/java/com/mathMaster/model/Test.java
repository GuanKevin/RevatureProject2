package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 
 * @author Pier Yos
 */
@Entity
@Table(name="M2_TEST")
public class Test {
	
	@Id
	@Column(name="TEST_ID")
	@SequenceGenerator(name="test", sequenceName="TEST_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="test", strategy=GenerationType.SEQUENCE)
	private int testId;
	
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER) 
	private Subject subjectId;
	
	public Test() {
		super();
	}
	
	public Test(Subject subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public int getTestId() {
		return testId;
	}
	
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public Subject getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", subjectId=" + subjectId + "]";
	}
}