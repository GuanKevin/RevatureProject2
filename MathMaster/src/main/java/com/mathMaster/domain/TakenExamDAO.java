package com.mathMaster.domain;

import java.sql.Timestamp;

import org.hibernate.Session;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public interface TakenExamDAO {
	public TakenExam getTakenExamById(int takenExamId);
	public void takeExam(Exam exam, Student student, int score, Timestamp timeTaken);
	public boolean updateScore(TakenExam takenExam, int score);
	public void setSession(Session session);
}
