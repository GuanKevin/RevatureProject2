package com.mathMaster.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author kevgu
 *
 */
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
@Entity
@Table(name="M2_COURSE")
public class Course {
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="COURSE", sequenceName="COURSE_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="COURSE", strategy=GenerationType.SEQUENCE)
	private int courseId;	
	@Column(unique=true)
	private int teacherId;
	@Column(unique=true)
	private String courseName;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Subject subjectId;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(int courseId, int teacherId, String courseName, Subject subjectId) {
		super();
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.courseName = courseName;
		this.subjectId = subjectId;
	}

	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Subject getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", teacherId=" + teacherId + ", courseName=" + courseName
				+ ", subjectId=" + subjectId + "]";
	}
}
