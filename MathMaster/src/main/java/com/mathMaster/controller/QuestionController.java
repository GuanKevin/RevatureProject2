package com.mathMaster.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value = "question")
public class QuestionController {

	private List<Question> questions = new ArrayList<Question>(); 
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	/**
	 * Saves  Question to the List (I commented out to save a question directly to the DB)
	 */
	@RequestMapping(value = "new/{examId}", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addQuestion(@RequestBody Question question, @PathVariable int examId) { 
		System.out.println("Add question: " + question);
		
		
		Exam exam =  businessDelegate.getExamById(examId);
		
		System.out.println("[     THIS IS THE EXAM ]" + exam);
		// Completing the question object with the exam object
		question.setExamQuestion(exam);
		
		System.out.println("[   this is the question with the exam ]" + question);
		// adding the new question to the list
		questions.add(question);
		
		System.out.println("the question is now added to the list");
		
		return new ResponseEntity<String>("Sucess! ", HttpStatus.CREATED);
	}

	// it will return the list of questions as JSON objects
	@RequestMapping(value="all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Question>> getAll(){
		System.out.println("Get All Questions..... update the view with the new data");		
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	

	
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public String addAllQuestions(HttpServletRequest req,
			HttpServletResponse resp){
		System.out.println("about to submit the list of questions to the database");
			
		businessDelegate.insertQuestions(questions);
		
		System.out.println("sucessfully submited the list to the database---CHECK THE DATABASE to see if the questions are there");
		
		
		for(Question question : questions){			
			System.out.println("[   THIS IS THE ID FOR THE QUESTIONS   ]   :  "+ question.getQuestionId());
		}
		questions = null;
		
		return "redirect:mgr";
	}
	
	@RequestMapping(value="page", method=RequestMethod.GET)
	public String questionPage(){
		System.out.println("I AM GOING TO MY TESTING HTML FILE");
		return "deniseQuestion.html"; // fowarding to questoin.html
	}

}


// TODO   FROM ORIGINAL QUESTION CONTROLLER ...HERE JUST INCASE I NEED IT

/*package com.mathMaster.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.service.Delegate;
import com.mathMaster.util.Facade;


@Controller
@RequestMapping(value = "question")
public class QuestionController {

	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	@RequestMapping(value = "new/{examId}", method =  RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addQuestion(@RequestBody Question question, @PathVariable int examId) { 
		List<Question> questions = new ArrayList<Question>(); 
		Exam exam = businessDelegate.getExamById(examId);
		question.setExamQuestion(exam);
		questions.add(question);
		
		return new ResponseEntity<String>("Sucess! ", HttpStatus.CREATED);
	}
	*//**
	 * Add the list of questions when the submit button is pressed
	 * @throws Exception 
	 *//*
	@RequestMapping(value = "create/{examId}", method =  {RequestMethod.POST}, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Question> addAllQuestions(@RequestBody Question[] ques, @PathVariable int examId){
		Facade facade = new Facade();
		
		Exam exam = facade.getExamById(examId);

		System.out.println(exam);

		List<Question> list = Arrays.asList(ques);

		for(Question quest: list){
			quest.setExamQuestion(exam);
		}

		facade.insertQuestions(list);
		
		try {
			facade.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "{quesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Question> getQuestion(@PathVariable int quesId){

		Facade facade = new Facade();
		Question question = facade.getQuestionByQuestionId(quesId);
		System.out.println("BOO");
		System.out.println("This is the question with question ID of " + quesId);
		System.out.println("[ THIS IS THE QUESTION ] " + question);
		
		try {
			facade.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

}*/