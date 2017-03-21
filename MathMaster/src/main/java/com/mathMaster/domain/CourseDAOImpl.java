package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Course;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;
/**
 * 
 * @author Pier Yos
 */
public class CourseDAOImpl implements CourseDAO {
	Session session;
	public CourseDAOImpl(Session session) {
		this.session = session;
	}
	
	public boolean createCourse(Course course) {
		Transaction txn = session.beginTransaction();
		try {
			session.save(course);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	public Course getCourseById(int id) {
		return (Course) session.load(Course.class, id);
	}

	public List<Course> getAllCourseByTeacherId(Teacher teacher) {
		Criteria criteria = session.createCriteria(Course.class);
		return (List<Course>) criteria.add(Restrictions.eq("teacher", teacher)).list();
	}

	public List<Course> getAllCourseByStudentId(Student student) {
		Criteria criteria = session.createCriteria(Course.class);
		return (List<Course>) criteria.add(Restrictions.eq("student", student)).list();
	}
}
