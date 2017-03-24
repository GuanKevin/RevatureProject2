package com.mathMaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathMaster.model.TakenExam;
import com.mathMaster.util.Facade;

@Controller
public class TakenExamController {
	@RequestMapping(value={"exam/takenExam/{takenExamId}"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TakenExam> getTakenExamById(@PathVariable int takenExamId) throws Exception {
		Facade facade = new Facade();
		TakenExam takenExam = facade.getTakenExamById(takenExamId);
		facade.close();
		return new ResponseEntity<>(takenExam, HttpStatus.OK);
	}
}