package com.mathMaster.controller;

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
import com.mathMaster.model.TakenExam;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value="TakenExam")
public class TakenExamController {
	
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	// Get TakenExam
	@RequestMapping(value={"{takenExamId}"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TakenExam> getTakenExamById(@PathVariable int takenExamId) throws Exception {
		return new ResponseEntity<>(businessDelegate.getTakenExamById(takenExamId), HttpStatus.OK);
	}

	// Get TakenExam Questions
	@RequestMapping(value="{takenExamId}/index", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<AnsweredQuestion>> getAllQuestionByTakenExamId(@PathVariable int takenExamId) throws Exception {
		return new ResponseEntity<Set<AnsweredQuestion>>(businessDelegate.getTakenExamById(takenExamId).getAnsweredQuestionSet(), HttpStatus.OK);
	}
	
	// Take Exam
	@RequestMapping(value="/{username}/{examId}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> createExam(@PathVariable String username, @PathVariable int examId, @RequestBody TakenExam takenExam) throws Exception {
		takenExam.setStudent(businessDelegate.getStudentByUsername(username));
		takenExam.setTakenExam(businessDelegate.getExamById(examId));
		System.out.println("takenExamId: " + takenExam.getTakenExamId());
		businessDelegate.createTakenExam(takenExam);
		System.out.println(takenExam.getTakenExamId());
		return new ResponseEntity<Integer>(takenExam.getTakenExamId(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{takenExamId}/{score}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Integer> updateExam(@PathVariable int takenExamId, @PathVariable int score) throws Exception {
		businessDelegate.updateScore(businessDelegate.getTakenExamById(takenExamId), score);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
}