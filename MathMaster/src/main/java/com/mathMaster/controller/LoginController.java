package com.mathMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("welcomePage")
public class LoginController {
	
	@RequestMapping(value="Login", method=RequestMethod.GET) 
	public String welomePage() {

		return "login.html";
	}
}
