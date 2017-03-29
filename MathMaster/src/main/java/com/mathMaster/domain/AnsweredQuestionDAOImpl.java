package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.AnsweredQuestion;

@Repository(value = "answeredQuestionDAO")
public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AnsweredQuestionDAOImpl() {
	}

	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		sessionFactory.getCurrentSession().save(answeredQuestion);
		return true;
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		for (AnsweredQuestion ansQuestion : answeredQuestions) {
			sessionFactory.getCurrentSession().save(ansQuestion);
		}
		return true;
	}

}
