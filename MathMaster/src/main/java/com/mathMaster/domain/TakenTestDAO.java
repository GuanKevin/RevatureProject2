package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Student;
import com.mathMaster.model.TakenTest;

public interface TakenTestDAO {
	public List<TakenTest> getAllTakenTest(int studentId);
	public TakenTest getTakenTestById(int takenTestId);
	public boolean takeTest(TakenTest takenTest);
}
