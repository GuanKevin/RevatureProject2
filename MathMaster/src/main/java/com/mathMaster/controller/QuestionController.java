package com.mathMaster.controller;

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
	/**
	 * Add the list of questions when the submit button is pressed
	 * @throws Exception 
	 */
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}

}
