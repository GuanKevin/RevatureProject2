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

import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.service.Delegate;

@Controller
@RequestMapping(value = "Course")
public class CourseController {

	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		businessDelegate.createCourse(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "{courseId}/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Student>> getStudentsByCourseId(@PathVariable int courseId) {
		return new ResponseEntity<Set<Student>>(businessDelegate.getCourseById(courseId).getStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "{courseId}/exams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Exam>> getExamsByCourseId(@PathVariable int courseId) {
		return new ResponseEntity<Set<Exam>>(businessDelegate.getCourseById(courseId).getExams(), HttpStatus.OK);
	}
}
