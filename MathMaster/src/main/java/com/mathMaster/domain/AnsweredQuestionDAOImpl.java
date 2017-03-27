package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.AnsweredQuestion;

@Repository(value = "answeredQuestionDAO")
public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO {

	private Session session;

	public AnsweredQuestionDAOImpl() {
	}

	public AnsweredQuestionDAOImpl(Session session) {
		this.session = session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		session.save(answeredQuestion);
		return true;
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		for (AnsweredQuestion ansQuestion : answeredQuestions) {
			session.save(ansQuestion);
		}
		return true;
	}

}
