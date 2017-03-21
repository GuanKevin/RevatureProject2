package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;

public class ExamDAOImpl implements ExamDAO {
	private Session session;

	public ExamDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExam(Course course) {
		Criteria criteria = session.createCriteria(Exam.class);
		return criteria.add(Restrictions.eq("course", course)).list();
	}

	public Exam getExamById(int examId) {
		return (Exam) session.load(Exam.class, examId);
	}

	public boolean createExam(Exam exam) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(exam);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
}
