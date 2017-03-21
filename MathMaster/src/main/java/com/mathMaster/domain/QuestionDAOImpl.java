package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Session;

import com.mathMaster.model.Question;

public class QuestionDAOImpl implements QuestionDAO{

	private Session session;
	
	public QuestionDAOImpl() {}
	
	public QuestionDAOImpl(Session session){
		this.session = session;
	}
	
	public Question getQuestionByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertQuestion(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertQuestions(List<Question> questions) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Question> getQuestionsByTestId(int testId) {
		// TODO Auto-generated method stub
		return null;
	}

}
