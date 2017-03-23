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

import com.mathMaster.model.Question;
import com.mathMaster.util.Facade;


@Controller
@RequestMapping(value = "question")
public class QuestionController {

	private List<Question> questions = new ArrayList<Question>(); 
	/**
	 * Saves  Question to the List (I commented out to save a question directly to the DB)
	 */
	@RequestMapping(value = "new", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addQuestion(@RequestBody final Question question) { 
		System.out.println("Add question: " + question);
		
		//adding it to the questions list to later save the whole list of questions at once
		questions.add(question);
		
		// saving the question directly to the database
		/* Facade facade =  new Facade();
		 facade.insertQuestion(question);*/
		
		return new ResponseEntity<String>("Sucess! ", HttpStatus.CREATED);
	}

	/**
	 * Add the list of questions when the submit button is pressed
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value = "submit", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAllQuestions() { 
		
		Facade facade = new Facade();
		
		facade.insertQuestions(questions);
		
		return new ResponseEntity<String>("Sucess Questions have been added! ", HttpStatus.CREATED);
	}
	
	
	@SuppressWarnings("resource")
	@RequestMapping(value = "{quesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Question> getQuestion(int quesId) {
		Facade facade = new Facade();
		Question question = facade.getQuestionByQuestionId(quesId);
		
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

}
