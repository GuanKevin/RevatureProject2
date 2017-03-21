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

	public boolean createCourse(Teacher teacher, String courseName, String subjectName) {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		try {
			Course course = new Course();
			course.setTeacher(teacher);
			course.setCourseName(courseName);
			course.setSubjectName(subjectName);
			
			session.save(course);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			session.close();
			sf.close();
		}
		
		
		return false;
	}

	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> getAllCourseByTeacherId(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> getAllCourseByStudentId(Student student) {
		// TODO Auto-generated method stub
		return null;
	}


}
