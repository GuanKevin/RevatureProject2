package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mathMaster.model.Course;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;
/**
 * 
 * @author Pier Yos
 */
public class CourseDAOImpl implements CourseDAO {
	Session session;
	public CourseDAOImpl(Session session) {
		this.session = session;
	}
	
	public boolean createCourse(Teacher teacher, String courseName, String subjectName) {
		Transaction txn = session.beginTransaction();
		try {
			Course course = new Course();
			course.setTeacher(teacher);
			course.setCourseName(courseName);
			course.setSubjectName(subjectName);
			
			session.save(course);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		}
		return false;
	}

	public Course getCourseById(int id) {
		return (Course) session.load(Course.class, id);
	}

	public List<Course> getAllCourseByTeacherId(Teacher teacher) {
		return (List<Course>) session.getNamedQuery("getAllCourseByTeacherId").setParameter("teacher", teacher);
	}

	public List<Course> getAllCourseByStudentId(Student student) {
		return (List<Course>) session.getNamedQuery("getAllCourseByStudentId").setParameter("student", student);
	}
}
