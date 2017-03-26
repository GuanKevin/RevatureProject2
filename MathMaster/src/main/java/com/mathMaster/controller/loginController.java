package com.mathMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="login")
public class loginController {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String welcomePage() {
		System.out.println("here");
		return "login.html";
	}
}
