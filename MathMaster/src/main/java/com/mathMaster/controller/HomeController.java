package com.mathMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mathMaster.service.Delegate;

@Controller
public class HomeController {
	
private Delegate businessDelegate;
	
	@Autowired
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	@RequestMapping(value="homie", method = RequestMethod.GET)
	public String homie() {
		return "pierlogin.html";
	}
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String startHtml(){
	    return "studentHome.html";
	} 
	
	@RequestMapping(value="login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object login(@RequestBody List<String> userinfo){
		
		String username = userinfo.get(0);
		String password = userinfo.get(1);
		
		if (username == null || password == null)
			return null;
		if (userinfo.get(2).equals("teacher")) {
			if (businessDelegate.teacherLogin(username, password) != null)
				return new ResponseEntity<Object>(businessDelegate.getTeacherByUserName(username),HttpStatus.OK);
			else
				return null;
		}
		else if (userinfo.get(2).equals("student")) {
			if (businessDelegate.studentLogin(username, password) != null)
				return new ResponseEntity<Object>(businessDelegate.getStudentByUsername(username),HttpStatus.OK);
			else
				return null;
		}
		else
			return null;
	}
}
