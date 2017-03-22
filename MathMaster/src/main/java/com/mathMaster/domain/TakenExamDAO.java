package com.mathMaster.domain;

import com.mathMaster.model.TakenExam;

public interface TakenExamDAO {
	public TakenExam getTakenExamById(int takenExamId);
	public boolean takeExam(TakenExam takenExam);
	public boolean updateScore(TakenExam takenExam, int score);
}
