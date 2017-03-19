package com.mathMaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * There are many courses that the student can take
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
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@Column(name="TEACHER_ID")
	private User teacherId;
	@Column(name="COURSE_NAME")
	private String courseName;
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	@Column(name="SUBJECT_ID")
	private Subject subjectId;
	@ManyToMany
	@JoinTable(name="COURSE_TEST")
	private List<Test> testList = new ArrayList<Test>();
	
	public Course() {}
	
	public Course(int courseId, User teacherId, String courseName, Subject subjectId) {
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
	
	public User getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(User teacherId) {
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
