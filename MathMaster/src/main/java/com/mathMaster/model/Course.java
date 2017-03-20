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
}
