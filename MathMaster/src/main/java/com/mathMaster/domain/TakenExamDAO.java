package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.TakenExam;

public interface TakenExamDAO {
	public TakenExam getTakenExamById(int takenExamId);
	public void createTakenExam(TakenExam takenExam);
	public boolean updateScore(TakenExam takenExam, int score);
	public void setSession(Session session);
}
