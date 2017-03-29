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

import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value="Exam")
public class ExamController {
	
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String spa(){
		return "exam.html";
	}

	// Get Exam
	@RequestMapping(value="{examId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> getExamById(@PathVariable int examId) throws Exception {
		return new ResponseEntity<Exam>(businessDelegate.getExamById(examId), HttpStatus.OK);
	}
	
	// Create Exam
	@RequestMapping(value="create/{courseId}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> createExam(@RequestBody Exam exam, @PathVariable int courseId) throws Exception {
		
		exam.setCourse(businessDelegate.getCourseById(courseId));
		businessDelegate.createExam(exam);
		return new ResponseEntity<Integer>(exam.getId(), HttpStatus.CREATED);
	}
	
	// Get Exam Questions
	@RequestMapping(value="{examId}/index", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Question>> getAllQuestionByExamId(@PathVariable int examId) throws Exception {
		Exam exam = businessDelegate.getExamById(examId);
		return new ResponseEntity<Set<Question>>(exam.getQuestionSet(), HttpStatus.OK);
	}
	
}
