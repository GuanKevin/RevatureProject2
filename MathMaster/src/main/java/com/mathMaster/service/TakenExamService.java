package com.mathMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void takeExam(TakenExam takenExam) {
		facade.takeExam(takenExam);
	}

	public void updateScore(TakenExam takenExam, int score) {
		facade.updateScore(takenExam, score);
	}
}
