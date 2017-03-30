package com.mathMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.util.Facade;

@Service
public class AnsweredQuestionService {
	private Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public void insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		facade.insertAnsweredQuestion(answeredQuestion);
	}

	public void insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		System.out.println("[      IN ANSWEREDQUESTION SERVICE ABOUT TO CALL THE FACADE    ]"); 
		facade.insertAnsweredQuestions(answeredQuestions);
		
		System.out.println("[      IN ANSWEREDQUESTION SERVICE ABOUT TO EXIT    ]"); 
	}
	
}
