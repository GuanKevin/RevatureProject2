package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Test;

public interface TestDAO {
	public List<Test> getAllTest(int courseId);
	public Test getTestById(int testId);
	public boolean createTest(Test test);
}
