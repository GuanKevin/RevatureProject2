package com.mathMaster.domain;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Question;

@Repository(value = "questionDAO")
public class QuestionDAOImpl implements QuestionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public QuestionDAOImpl() {
	}

	@Transactional
	public Question getQuestionByQuestionId(int questionId) {
		Question question = (Question) sessionFactory.getCurrentSession().load(Question.class, questionId);
		return question;
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean insertQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);

		return true;
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean insertQuestions(List<Question> questions) {
		System.out.println("[     IN QUESTION DAO     ]");

		for (Question question : questions) {
			sessionFactory.getCurrentSession().saveOrUpdate(question);
		}
		System.out.println("[     EXITING QUESTION DAO     ]");
		
		return true;
	}
}
