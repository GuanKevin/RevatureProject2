package com.mathMaster.domain;

import com.mathMaster.model.Exam;

public interface ExamDAO {
	public Exam getExamById(int examId);
	public boolean createExam(Exam exam);
}
