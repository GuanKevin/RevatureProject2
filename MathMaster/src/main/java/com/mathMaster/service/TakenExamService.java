package com.mathMaster.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.util.Facade;

@Service
public class TakenExamService {
	private Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public TakenExam getTakenExamById(int id) {
		return facade.getTakenExamById(id);
	}
	
	public void takeExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		facade.takeExam(exam, student, score, timeTaken);
	}

	public void updateScore(TakenExam takenExam, int score) {
		facade.updateScore(takenExam, score);
	}
}
