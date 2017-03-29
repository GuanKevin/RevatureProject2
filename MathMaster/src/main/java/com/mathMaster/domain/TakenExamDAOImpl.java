package com.mathMaster.domain;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.TakenExam;

@Repository(value = "takenExamDAO")
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

	public void createTakenExam(TakenExam takenExam) {
		System.out.println("saving");
		System.out.println(takenExam);
		session.saveOrUpdate(takenExam);
		System.out.println("save complete");
	}

	public boolean updateScore(TakenExam takenExam, int score) {
		takenExam.setScore(score);
		session.update(takenExam);
		return true;
	}

}
