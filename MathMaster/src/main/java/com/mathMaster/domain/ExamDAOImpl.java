package com.mathMaster.domain;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Exam;

@Repository(value="examDAO")
public class ExamDAOImpl implements ExamDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public Exam getExamById(int examId) {
		return (Exam) session.get(Exam.class, examId);
	}
	
	@Transactional
	public void createExam(Exam exam) {
		session.saveOrUpdate(exam);
	}

	public ExamDAOImpl() {
		super();
	}
}
