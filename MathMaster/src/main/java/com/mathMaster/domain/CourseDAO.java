package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Course;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;

public interface CourseDAO {
	public boolean createCourse(Teacher teacher, String courseName, String subjectName);
	public Course getCourseById(int id);
	public List<Course> getAllCourseByTeacherId(Teacher teacher);
	public List<Course> getAllCourseByStudentId(Student student);
}
