package com.mathMaster.controller;

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

import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value="Exam")
public class ExamController {
	
	@RequestMapping(value="{examId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> getExamById(@PathVariable int examId) throws Exception {
		Facade facade = new Facade();
		System.out.println("Looking for exam id: " + examId);
		Exam exam = facade.getExamById(examId);
		System.out.println(exam);
		facade.close();
		return new ResponseEntity<Exam>(exam, HttpStatus.OK);
	}
	
	@RequestMapping(value="create/{courseId}", method={RequestMethod.GET, RequestMethod.POST}, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> createExam(@RequestBody Exam exam, @PathVariable int courseId) throws Exception {
		Facade facade = new Facade();
		exam.setCourse(facade.getCourseById(courseId));
		facade.createExam(exam);
		facade.close();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="{examId}/index", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Question>> getAllQuestionByExamId(@PathVariable int examId) throws Exception {
		Facade facade = new Facade();
		Exam exam = facade.getExamById(examId);
		facade.close();
		return new ResponseEntity<Set<Question>>(exam.getQuestions(), HttpStatus.OK);
	}
	
}
