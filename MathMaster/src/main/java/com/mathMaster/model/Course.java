package com.mathMaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
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
	private int courseId;
	
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	private Teacher teacher;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();

	
	public Course () {}
	
	public Course(int courseId, Teacher teacher, String courseName, String subjectName, List<Student> students) {
		super();
		this.courseId = courseId;
		this.teacher = teacher;
		this.courseName = courseName;
		this.subjectName = subjectName;
		this.students = students;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", teacher=" + teacher + ", courseName=" + courseName + ", subjectName="
				+ subjectName + ", students=" + students + "]";
	}

}
