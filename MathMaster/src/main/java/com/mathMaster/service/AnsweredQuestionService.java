package com.mathMaster.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.util.Facade;

@Service
public class AnsweredQuestionService {
	private Facade facade;

	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public void insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		facade.insertAnsweredQuestion(answeredQuestion);
	}

	public void insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		facade.insertAnsweredQuestions(answeredQuestions);
	}
	
}
