package com.mathMaster.domain;

import org.hibernate.SessionFactory;

import com.mathMaster.model.Exam;

public interface ExamDAO {
	public Exam getExamById(int examId);
	public void createExam(Exam exam);
	public void setSessionFactory(SessionFactory sessionFactory);
}
