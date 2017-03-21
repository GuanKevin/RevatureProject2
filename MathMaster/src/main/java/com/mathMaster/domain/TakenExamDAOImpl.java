package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.TakenExam;

public class TakenExamDAOImpl implements TakenExamDAO {
	Session session;

	public TakenExamDAOImpl(Session session) {
		this.session = session;
	}

	public TakenExam getTakenExamById(int takenExamId) {
		return (TakenExam) session.get(TakenExam.class, takenExamId);
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
