package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.TakenExam;

public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO{

	private Session session;
	
	public AnsweredQuestionDAOImpl() {}
	
	public AnsweredQuestionDAOImpl(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<AnsweredQuestion> getQuestionsByTakenTestId(TakenExam takenExam) {
		Criteria criteria = session.createCriteria(AnsweredQuestion.class);
		return criteria.add(Restrictions.eq("takenExam", takenExam)).list();
	}

	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(answeredQuestion);
			tx.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		Transaction tx = session.beginTransaction();
		try{
			for(AnsweredQuestion ansQuestion : answeredQuestions){
				// using the method to save each object from the list
				insertAnsweredQuestion(ansQuestion);
			}
			tx.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}
