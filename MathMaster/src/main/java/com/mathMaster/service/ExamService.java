package com.mathMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Exam;
import com.mathMaster.util.Facade;

@Service
public class ExamService {
	private Facade facade;
	
    @Autowired
    public void setFacade(Facade facade) {
        this.facade = facade;
    }

    public Exam getExamById(int id ) {
        return facade.getExamById(id);
    }
    
    public void createExam(Exam exam) {
    	facade.createExam(exam);
    }
}
