package com.mathMaster.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="M2_STUDENT")
public class Student {
	@Id
	@Column(name="STUDENT_ID")
	@SequenceGenerator(name="STUDENT", sequenceName="STUDENT_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(generator="STUDENT", strategy=GenerationType.SEQUENCE)
	private int studentId;
	
	@Column(name="USER_NAME", unique=true)
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL", unique=true)
	private String email;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE")
	private Set<Course> courses = new HashSet<Course>();
	
	@OneToMany(mappedBy="student")
	private Set<TakenExam> takenExams = new HashSet<TakenExam>();
	
	public Student() {}

	public Student(String userName, String password, String firstName, String lastName, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Course> getCourseSet() {
		return courses;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courses = courseSet;
	}

	public Set<TakenExam> getTakenExams() {
		return takenExams;
	}

	public void setTakenExams(Set<TakenExam> takenExams) {
		this.takenExams = takenExams;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
