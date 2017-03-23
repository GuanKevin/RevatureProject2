package com.mathMaster.domain;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public class TakenExamDAOImpl implements TakenExamDAO {
	Session session;

	public TakenExamDAOImpl(Session session) {
		this.session = session;
	}

	public TakenExam getTakenExamById(int takenExamId) {
		return (TakenExam) session.get(TakenExam.class, takenExamId);
	}

	public boolean takeExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		Transaction tx = session.beginTransaction();
		try {
			TakenExam takenExam = new TakenExam(exam, student, score, timeTaken);
			session.save(takenExam);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public boolean updateScore(TakenExam takenExam, int score) {
		Transaction tx = session.beginTransaction();
		try {
			takenExam.setScore(score);
			session.update(takenExam);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}
