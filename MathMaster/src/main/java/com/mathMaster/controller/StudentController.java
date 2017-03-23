package com.mathMaster.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value="Student")
public class StudentController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<TakenExam>> getCourseByStudentId() throws Exception {
		Facade fa = new Facade();
		Student stu = fa.getStudentByUsername("Student001");
		return new ResponseEntity<Set<TakenExam>>(stu.getTakenExams(), HttpStatus.OK);
	}
}
