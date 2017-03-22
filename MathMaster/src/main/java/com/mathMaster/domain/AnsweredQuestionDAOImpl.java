package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.AnsweredQuestion;

public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO {

	private Session session;

	public AnsweredQuestionDAOImpl() {
	}

	public AnsweredQuestionDAOImpl(Session session) {
		this.session = session;
	}

	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(answeredQuestion);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		Transaction tx = session.beginTransaction();
		try {
			for (AnsweredQuestion ansQuestion : answeredQuestions) {
				// using the method to save each object from the list
				insertAnsweredQuestion(ansQuestion);
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}
