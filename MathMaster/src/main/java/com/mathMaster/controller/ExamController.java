package com.mathMaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value="exam")
public class ExamController {
	
	@RequestMapping(value="{examId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> getExamById(@PathVariable int examId) throws Exception {
		Facade facade = new Facade();
		System.out.println("Looking for exam id: " + examId);
		Exam exam = facade.getExamById(examId);
		System.out.println(exam);
		return new ResponseEntity<Exam>(exam, HttpStatus.OK);
	}
	
	@RequestMapping(value="teacher/{username}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getExamById(@PathVariable String username) throws Exception {
		Facade facade = new Facade();
		Teacher teacher = facade.getTeacherByUserName(username);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
}
