package com.mathMaster.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "Tquestion")
public class TESTQuestionController {

	private List<Question> questions = new ArrayList<Question>(); 
	
	/**
	 * Saves  Question to the List (I commented out to save a question directly to the DB)
	 */
	@RequestMapping(value = "new/{examId}", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addQuestion(@RequestBody Question question, @PathVariable int examId) { 
		System.out.println("Add question: " + question);
		
		//adding it to the questions list to later save the whole list of questions at once
		Facade facade = new Facade();
		
		Exam exam = facade.getExamById(examId);
		System.out.println("[     THIS IS THE EXAM ]" + exam);
		// Completing the question object with the exam object
		question.setExamQuestion(exam);
		
		System.out.println("[   this is the question with the exam ]" + question);
		// adding the new question to the list
		questions.add(question);
		
		System.out.println("the question is now added to the list");
		try {
			facade.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		Facade facade = new Facade();
	
		facade.insertQuestions(questions);
		
		try { 
			facade.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sucessfully submited the list to the database---CHECK THE DATABASE to see if the questions are there");
		
		questions = null;
		
		return "redirect:mgr";
	}
	
	@RequestMapping(value="page", method=RequestMethod.GET)
	public String questionPage(){
		System.out.println("I AM GOING TO MY TESTING HTML FILE");
		return "deniseQuestion.html"; // fowarding to questoin.html
	}

}