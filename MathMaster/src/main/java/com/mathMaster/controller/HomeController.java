package com.mathMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="homie", method = RequestMethod.GET)
	public String homie() {
		return "pierhome.html";
	}
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String startHtml(){
	    return "studentHome.html";
	} 
}