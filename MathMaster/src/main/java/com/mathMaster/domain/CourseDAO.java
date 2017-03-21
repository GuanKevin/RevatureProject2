package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Course;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;
/**
 * 
 * @author Pier Yos
 */
public interface CourseDAO {
	public boolean createCourse(Course course);
	public Course getCourseById(int id);
	public List<Course> getAllCourseByTeacherId(Teacher teacher);
	public List<Course> getAllCourseByStudentId(Student student);
}
