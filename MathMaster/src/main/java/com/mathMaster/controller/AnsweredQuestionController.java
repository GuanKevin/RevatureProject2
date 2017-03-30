package com.mathMaster.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

 	List<AnsweredQuestion> ansQues = new ArrayList<AnsweredQuestion>();
 	
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	/**
	 * Add the list of questions when the submit button is pressed
	 */
	@RequestMapping(value = "submit/{takenExamId}", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAllAnsweredQuestions(@RequestBody AnsweredQuestion[] ansQues, @PathVariable int takenExamId) { 

		TakenExam takenExam = businessDelegate.getTakenExamById(takenExamId);
		
		System.out.println("[     this is the taken exam      ]: " + takenExam.getTakenExamId() + " " + takenExam.getTakenExam());
	
		List<AnsweredQuestion> list = Arrays.asList(ansQues);
		Set<Question> questions = takenExam.getTakenExam().getQuestionSet();
		
		System.out.println("[      THIS IS THE SET OF QUESTIONS      ]"+questions);
		
		Iterator<Question> iter = questions.iterator();
		
		// this is for testing purposes
		for(AnsweredQuestion ansquest: list){
			
		    Question question = iter.next();
			ansquest.setTakenExamQuestion(takenExam);
			ansquest.setQuestion(question);
		}

		businessDelegate.insertAnsweredQuestions(list);
		
		System.out.println("SUCESS CHECK THE DATABASE IT WAS ENTERED");
		
		return new ResponseEntity<String>("Sucess all Answered Questions have been added! ", HttpStatus.CREATED);
	}

}
