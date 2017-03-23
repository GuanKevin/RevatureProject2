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
import com.mathMaster.model.Teacher;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "Course")
public class CourseController {

	@RequestMapping(value = "/{courseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Course> getByCourseById(@PathVariable int courseId) throws Exception {
		Facade facade = new Facade();
		Course course = facade.getCourseById(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Course>> getByAllCourse() throws Exception {
		Facade facade = new Facade();
		Teacher teacher = facade.getTeacherByUserName("Code_Blooded_KG");
		
		return new ResponseEntity<Set<Course>>(teacher.getCourses(), HttpStatus.OK);
	}
}
