package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Exam;

public class ExamDAOImpl implements ExamDAO{
	private Session session;
	
	public ExamDAOImpl(Session session) {
		this.session = session;
	}

	public Exam getExamById(int examId) {
		Criteria criteria = session.createCriteria(Exam.class);
		return (Exam) criteria.add(Restrictions.eq("TEST_ID", examId)).uniqueResult();
	}

	public boolean createExam(Exam exam) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(exam);
			tx.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
}
