package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Question;
import com.mathMaster.model.Test;

public class QuestionDAOImpl implements QuestionDAO {

	private Session session;

	public QuestionDAOImpl() {
	}

	public QuestionDAOImpl(Session session) {
		this.session = session;
	}

	public Question getQuestionByQuestionId(int questionId) {
		Question question = (Question) session.load(Question.class, questionId);
		return question;
	}

	public boolean insertQuestion(Question question) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(question);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public boolean insertQuestions(List<Question> questions) {
		Transaction tx = session.beginTransaction();
		try {
			for (Question question : questions) {
				// using the method to save each object from the list
				insertQuestion(question);
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Question> getQuestionsByTestId(Test test) {
		Criteria criteria = session.createCriteria(Question.class);
		return criteria.add(Restrictions.eq("takenTest", test)).list();

	}

}
