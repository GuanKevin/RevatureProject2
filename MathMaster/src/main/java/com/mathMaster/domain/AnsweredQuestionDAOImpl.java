package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;

import com.mathMaster.model.AnsweredQuestion;

public class AnsweredQuestionDAOImpl implements AnsweredQuestionDAO{

	private Session session;
	
	public AnsweredQuestionDAOImpl() {}
	
	public AnsweredQuestionDAOImpl(Session session){
		this.session = session;
	}
	
	public List<AnsweredQuestion> getQuestionsByTakenTestId(int takenTestId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		// TODO Auto-generated method stub
		return false;
	}

}
