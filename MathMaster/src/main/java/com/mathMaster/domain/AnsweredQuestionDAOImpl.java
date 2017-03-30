package com.mathMaster.domain;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.AnsweredQuestion;

@Repository(value = "answeredQuestionDAO")
public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AnsweredQuestionDAOImpl() {
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		sessionFactory.getCurrentSession().save(answeredQuestion);
		return true;
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		for (AnsweredQuestion ansQuestion : answeredQuestions) {
			sessionFactory.getCurrentSession().save(ansQuestion);
		}
		return true;
	}

}
