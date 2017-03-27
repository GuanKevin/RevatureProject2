package com.mathMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mathMaster.model.Course;
import com.mathMaster.model.Teacher;
import com.mathMaster.service.Delegate;
import com.mathMaster.util.Facade;

@Controller
public class TeacherController {
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@RequestMapping(value = "Teacher/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable String username) throws Exception {
		return new ResponseEntity<Teacher>(businessDelegate.getTeacherByUserName(username), HttpStatus.OK);
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
