package com.mathMaster.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "answeredQuestion")
public class AnsweredQuestionController {
	///////////////////////// TESTING PURPOSE... IDEALLY THE QUESTION OBJECT SHOULD BE IN THE JSON FOR EACH SUMBITTED ANSWER
	// REMOVE THE ENTERING QUESTION OBJECT ..it should be entered in the json in the front end
	/**
	 * Add the list of questions when the submit button is pressed
	 */
	@RequestMapping(value = "submit/{takenExamId}", method =  RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addAllAnsweredQuestions(@RequestBody AnsweredQuestion[] ansQues, @PathVariable int takenExamId) { 

		Facade facade = new Facade();
		
		TakenExam takenExam = facade.getTakenExamById(takenExamId);
		
		// set of all the questions for the exam of this taken exam
		Set<Question> questions = takenExam.getTakenExam().getQuestions(); 
		
		System.out.println("[  SET OF QUESTIONS   ]" + questions);
		List<AnsweredQuestion> list = Arrays.asList(ansQues);
		System.out.println(list);
		Iterator<Question> it = questions.iterator();
	     
	     // this is where i will i will set taken exam and question to each answered question
	    // ideally in the front end the question should be insereted in the JSON before sending
		// the list to be submmited
		
		// this is for testing purposes
	/*	for(AnsweredQuestion ansquest: list){
		     Question question = it.next();
			ansquest.setTakenExamQuestion(takenExam);
			ansquest.setQuestion(question);
		}*/
		
		System.out.println("[   TAKEN EXAM   ]    " + takenExam);
		System.out.println("[   LIST OF ANSWERED QUESTIONS   ]    " + list);
		//facade.insertAnsweredQuestions(list);

		
		try {
			facade.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Sucess all Answered Questions have been added! ", HttpStatus.CREATED);
	}

}
