package com.mathMaster.domain;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public interface TakenExamDAO {
	public TakenExam getTakenExamById(int takenExamId);
	public boolean takeExam(Exam exam, Student student, int score, int timeTaken);
	public boolean updateScore(TakenExam takenExam, int score);
}
