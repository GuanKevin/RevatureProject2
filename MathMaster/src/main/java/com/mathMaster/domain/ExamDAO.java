package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;

public interface ExamDAO {
	public List<Exam> getAllExam(Course course);
	public Exam getExamById(int examId);
	public boolean createExam(Exam exam);
}
