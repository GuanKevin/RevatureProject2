package com.mathMaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Denise
 *
 */

@Entity
@Table(name="M2_SUBJECT")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class Subject {
	@Id
	@Column(name="SUBJECT_ID")
	@SequenceGenerator(name="SUBJECT", sequenceName="SUBJECT_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="SUBJECT", strategy=GenerationType.SEQUENCE)
	private int subjectId;
	@Column(unique=true)
	private String subjectName;
	
	public Subject(int subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public Subject() {}
	
	public int getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
}
