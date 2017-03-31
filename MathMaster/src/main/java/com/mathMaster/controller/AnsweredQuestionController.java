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

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Question;
import com.mathMaster.model.TakenExam;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value = "answeredQuestion") 
public class AnsweredQuestionController {

	List<AnsweredQuestion> answeredQuestions = new ArrayList<AnsweredQuestion>();
 	
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	/**
	 * Saves  Question to the List (I commented out to save a question directly to the DB)
	 */
	@RequestMapping(value = "new/{takenExamId}/{questionId}", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAnsweredQuestion(@RequestBody AnsweredQuestion ansques, @PathVariable int questionId, @PathVariable int takenExamId) { 
		
		Question question =  businessDelegate.getQuestionByQuestionId(questionId);
		TakenExam takenExam = businessDelegate.getTakenExamById(takenExamId);

		ansques.setQuestion(question);
		ansques.setTakenExamQuestion(takenExam);
		
		// add to list if i use addAllAnsweredQuestions(....)
		answeredQuestions.add(ansques);
		
		businessDelegate.insertAnsweredQuestion(ansques);

		
		return new ResponseEntity<String>("Success answered question has been added! ", HttpStatus.CREATED);
	}

	
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	@ResponseBody
	public String addAllAnsweredQuestions(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("about to submit the list of answered questions to the database");
			
		businessDelegate.insertAnsweredQuestions(answeredQuestions);
		
		System.out.println("sucessfully submited the list to the database---CHECK THE DATABASE to see if the questions are there");
		
		for(AnsweredQuestion ansQues : answeredQuestions){			
			System.out.println("[   THIS IS THE ID FOR THE ANSWERED QUESTIONS   ]   :  "+ ansQues.getAnsQuesId());
		}

		// reseting the list to null for the next call
		answeredQuestions = null;
		
		return "";
	}
}

