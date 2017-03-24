package com.mathMaster.controller;

import java.sql.Timestamp;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value="TakenExam")
public class TakenExamController {
	
	@RequestMapping(value={"{takenExamId}"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TakenExam> getTakenExamById(@PathVariable int takenExamId) throws Exception {
		Facade facade = new Facade();
		TakenExam takenExam = facade.getTakenExamById(takenExamId);
		facade.close();
		return new ResponseEntity<>(takenExam, HttpStatus.OK);
	}
	
	@RequestMapping(value="{takenExamxamId}/index", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<AnsweredQuestion>> getAllQuestionByTakenExamId(@PathVariable int takenExamId) throws Exception {
		Facade facade = new Facade();
		TakenExam takenExam = facade.getTakenExamById(takenExamId);
		facade.close();
		return new ResponseEntity<Set<AnsweredQuestion>>(takenExam.getAnsweredQuestionSet(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{username}/{examId}", method={RequestMethod.GET, RequestMethod.POST}, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> createExam(@PathVariable String username, @PathVariable int examId) throws Exception {
		Facade facade = new Facade();
		Exam exam = facade.getExamById(examId);
		Student student = facade.getStudentByUsername(username);
		facade.takeExam(exam, student, 0, new Timestamp(System.currentTimeMillis()));
		facade.close();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}