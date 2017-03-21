package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Course;
import com.mathMaster.model.Test;

public interface TestDAO {
	public List<Test> getAllTest(Course course);
	public Test getTestById(int testId);
	public boolean createTest(Test test);
}
