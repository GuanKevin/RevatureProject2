package com.mathMaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.Teacher;
import com.mathMaster.util.Facade;

@Controller
@RequestMapping(value = "Teacher")
public class TeacherController {

	/**
	 * localhost:7001/MathMaster/Teacher/Code_Blooded_KG
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable String username) throws Exception {
		Facade facade = new Facade();
		Teacher teacher = facade.getTeacherByUserName(username);
		facade.close();
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
	
	
}
