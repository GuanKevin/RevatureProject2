package com.mathMaster.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Exam;

@Repository(value="examDAO")
public class ExamDAOImpl implements ExamDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public Exam getExamById(int examId) {
		return (Exam) sessionFactory.getCurrentSession().get(Exam.class, examId);
	}
	
	@Transactional
	public void createExam(Exam exam) {
		sessionFactory.getCurrentSession().saveOrUpdate(exam);
	}

	public ExamDAOImpl() {
		super();
	}
}
