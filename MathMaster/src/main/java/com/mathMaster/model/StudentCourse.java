package com.mathMaster.model;

public class StudentCourse {
	private int studentCourseId;
	private User studentId;
	private Course courseId;
	
	public StudentCourse() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentCourse(int studentCourseId, User studentId, Course courseId) {
		super();
		this.studentCourseId = studentCourseId;
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getStudentCourseId() {
		return studentCourseId;
	}
	
	public void setStudentCourseId(int studentCourseId) {
		this.studentCourseId = studentCourseId;
	}
	
	public User getStudentId() {
		return studentId;
	}
	
	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}
	
	public Course getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public String toString() {
		return "StudentCourse [studentCourseId=" + studentCourseId + ", studentId=" + studentId + ", courseId="
				+ courseId + "]";
	}
}
