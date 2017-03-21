package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public class TakenExamDAOImpl implements TakenExamDAO {
	Session session;

	public TakenExamDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<TakenExam> getAllExamTest(Student student) {
		Criteria criteria = session.createCriteria(TakenExam.class);
		return criteria.add(Restrictions.eq("student", student)).list();
	}

	public TakenExam getTakenExamById(int takenExamId) {
		Criteria criteria = session.createCriteria(TakenExam.class);
		return (TakenExam) criteria.add(Restrictions.eq("TAKEN_TEST_ID", takenExamId)).uniqueResult();
	}

	public boolean takeExam(TakenExam takenExam) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(takenExam);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}
