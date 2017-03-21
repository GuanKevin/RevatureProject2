package com.mathMaster.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//DENISE TEST
@Entity
@Table(name="M2_COURSE")
@NamedQueries({
	
})
@NamedNativeQueries({
	
})
public class Course {
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="COURSE", sequenceName="COURSE_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="COURSE", strategy=GenerationType.SEQUENCE)
	private int courseId;
	
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	private Teacher teacher;
	
	@Column(name="COURSE_NAME", unique=true)
	private String courseName;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<Student>();

	
	public Course () {}
	
	public Course(Teacher teacher, String courseName, String subjectName) {
		super();
		this.teacher = teacher;
		this.courseName = courseName;
		this.subjectName = subjectName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", teacher=" + teacher + ", courseName=" + courseName + ", subjectName="
				+ subjectName + ", students=" + students + "]";
	}

}
