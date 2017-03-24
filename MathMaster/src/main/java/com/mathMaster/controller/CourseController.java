package com.mathMaster.controller;


import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "Course")
public class CourseController {

	@RequestMapping(value = "{courseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Course> getByCourseById(@PathVariable int courseId) {
		Facade facade = new Facade();
		try {
			Course course = facade.getCourseById(courseId);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getByAllCourse(HttpServletRequest req) {
		Facade facade = new Facade();
		Teacher teacher = facade.getTeacherByUserName("Code_Blooded_KG");
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
		// return new ResponseEntity<Set<Course>>(teacher.getCourses(),
		// HttpStatus.OK);
	}

	@RequestMapping(value = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		try {
			new Facade().createCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}
}
