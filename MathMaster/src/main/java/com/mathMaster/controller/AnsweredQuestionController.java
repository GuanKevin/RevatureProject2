package com.mathMaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "answeredQuestion")
public class AnsweredQuestionController {
	private List<AnsweredQuestion> answeredQuestions = new ArrayList<AnsweredQuestion>(); 
	
	/**
	 * Saves  AnsweredQuestion to the List (I commented out to save a answered question directly to the DB)
	 */
	@RequestMapping(value = "new", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAnsweredQuestion(@RequestBody final AnsweredQuestion ansQuestion) { 
		System.out.println("Add answered question: " + ansQuestion);
		
		//adding it to the answeredQuestions list to later save the whole list of answeredQuestions at once
		answeredQuestions.add(ansQuestion);
		
		// saving the question directly to the database
		 /*Facade facade =  new Facade();
		 facade.insertAnsweredQuestion(ansQuestion);*/
		
		return new ResponseEntity<String>("Sucess! ", HttpStatus.CREATED);
	}

	/**
	 * Add the list of questions when the submit button is pressed
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value = "submit", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAllAnsweredQuestions() { 
		
		Facade facade = new Facade();
		
		facade.insertAnsweredQuestions(answeredQuestions);
		
		return new ResponseEntity<String>("Sucess all Answered Questions have been added! ", HttpStatus.CREATED);
	}
}
