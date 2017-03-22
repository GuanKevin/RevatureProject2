package com.mathMaster.util;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Student;

public class FFFacade {

	private StudentDAOImpl studentDAO;
	private CourseDAOImpl courseDAO;

	public FFFacade() {
		studentDAO = new StudentDAOImpl(session);
		courseDAO = new CourseDAOImpl(session);
	}

	public boolean createCourse(Course course) {
		return courseDAO.createCourse(course);
	}

	public Course getCourseById(int id) {
		return courseDAO.getCourseById(id);
	}

	public Student getStudentByUsername(String username) {
		return studentDAO.getStudentByUsername(username);
	}

	public boolean createStudent(Student student) {
		return studentDAO.createStudent(student);
	}

	public boolean removeStudent(Student student) {
		return studentDAO.removeStudent(student);
	}
}
