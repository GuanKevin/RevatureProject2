package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public interface TakenExamDAO {
	public List<TakenExam> getAllExamTest(Student student);
	public TakenExam getTakenExamById(int takenExamId);
	public boolean takeExam(TakenExam takenExam);
}
