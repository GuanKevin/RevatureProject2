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
public class TeacherController {

	/**
	 * localhost:7001/MathMaster/Teacher/Code_Blooded_KG
	 * Gets username from HTTP and returns user data
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "Teacher/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable String username) throws Exception {
		Facade facade = new Facade();
		Teacher teacher = facade.getTeacherByUserName(username);
		System.out.println(teacher);
		facade.close();
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
	
	@RequestMapping(value = "Teacher/Course/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Course>> getAllCourseByTeacherUsername(@PathVariable String username) throws Exception {
		Facade facade = new Facade();
		Set<Course > courseSet= facade.getTeacherByUserName(username).getCourses();
		facade.close();
		return new ResponseEntity<Set<Course>>(courseSet, HttpStatus.OK);
	}
}
