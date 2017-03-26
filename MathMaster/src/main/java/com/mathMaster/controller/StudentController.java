package com.mathMaster.controller;

import java.util.Set;

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
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value="Student")
public class StudentController {
	
	@RequestMapping(value="{username}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Student> getStudentById(@PathVariable String username) throws Exception {
		Facade fa = new Facade();
		Student stu = fa.getStudentByUsername(username);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Course>> getAllCourseByStudent(@PathVariable String username) throws Exception {
		Facade fa = new Facade();
		Student stu = fa.getStudentByUsername(username);
		return new ResponseEntity<Set<Course>>(stu.getCourseSet(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course/{courseId}/Exam", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Exam>> getAllStudentExamByCourse(@PathVariable String username, @PathVariable int courseId) throws Exception {
		Facade fa = new Facade();
		Set<Exam> exams = fa.getCourseById(courseId).getExams();
		return new ResponseEntity<Set<Exam>>(exams, HttpStatus.OK);
	}
	
	@RequestMapping(value="{username}/Course/{courseId}/Exam/{examId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Exam> getExamByStudentCourse(@PathVariable String username, @PathVariable int courseId, @PathVariable int examId) throws Exception {
		Facade fa = new Facade();
		Exam exams = fa.getExamById(examId);
		return new ResponseEntity<Exam>(exams, HttpStatus.OK);
	}
}
