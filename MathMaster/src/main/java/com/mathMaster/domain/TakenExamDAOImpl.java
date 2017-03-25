package com.mathMaster.domain;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

@Repository(value="takenExamDAO")
public class TakenExamDAOImpl implements TakenExamDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public TakenExamDAOImpl() {
		super();
	}

	public TakenExam getTakenExamById(int takenExamId) {
		return (TakenExam) session.get(TakenExam.class, takenExamId);
	}

	public void takeExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		TakenExam takenExam = new TakenExam(exam, student, score, timeTaken);
		session.saveOrUpdate(takenExam);
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
