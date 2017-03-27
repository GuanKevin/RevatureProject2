package com.mathMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Question;
import com.mathMaster.util.Facade;

@Service
public class QuestionService {
	private Facade facade;
	
	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public Question getQuestionByQuestionId(int questionId) {
		return facade.getQuestionByQuestionId(questionId);
	}

	public void insertQuestion(Question question) {
		facade.insertQuestion(question);
	}

	public void insertQuestions(List<Question> questions) {
		facade.insertQuestions(questions);;
	}	
}
