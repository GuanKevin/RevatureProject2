package com.mathMaster.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value="Student")
public class StudentController { 
	
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Student> getStudentById(@PathVariable String username) throws Exception {
		return new ResponseEntity<Student>(businessDelegate.getStudentByUsername(username), HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Course>> getAllCourseByStudent(@PathVariable String username) throws Exception {
		return new ResponseEntity<Set<Course>>(businessDelegate.getStudentByUsername(username).getCourseSet(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course/{courseId}/Exam", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Exam>> getAllStudentExamByCourse(@PathVariable String username, @PathVariable int courseId) throws Exception {
		return new ResponseEntity<Set<Exam>>(businessDelegate.getCourseById(courseId).getExams(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course/{courseId}/Exam/{examId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> getExamByStudentCourse(@PathVariable String username, @PathVariable int courseId, @PathVariable int examId) throws Exception {
		return new ResponseEntity<Exam>(businessDelegate.getExamById(examId), HttpStatus.OK);
	}
}
