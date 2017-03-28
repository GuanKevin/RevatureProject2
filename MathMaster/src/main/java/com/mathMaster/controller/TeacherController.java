package com.mathMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mathMaster.service.Delegate;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "Teacher")
public class TeacherController {
	private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	/**
	 * http://localhost:7001/MathMaster/Teacher/Code_Blooded_KG
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable String username) throws Exception {
		return new ResponseEntity<Teacher>(businessDelegate.getTeacherByUserName(username), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET) 
	public String teacherView () {
		return "teacherHome.html";
	}
	
	@RequestMapping(value = "Course/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<Course>> getAllCourseByTeacherUsername(@PathVariable String username) throws Exception {
		Facade facade = new Facade();
		Set<Course > courseSet= facade.getTeacherByUserName(username).getCourses();
		facade.close();
		return new ResponseEntity<Set<Course>>(courseSet, HttpStatus.OK);
	}
}
