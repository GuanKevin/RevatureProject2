package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.Exam;

public interface ExamDAO {
	public Exam getExamById(int examId);
	public void createExam(Exam exam);
	public void setSession(Session session);
}
