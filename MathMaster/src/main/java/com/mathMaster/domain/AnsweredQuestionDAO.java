package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.TakenExam;

/**
 * This interface will be used for the AnsweredQuestionDAOImpl
 * @author Denise
 *
 */
public interface AnsweredQuestionDAO {

	/**
	 * save a new answered question
	 * @param answeredQuestion
	 * 							return boolean for testing
	 */
	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion);

	/**
	 * save all answered questions from a test submitted
	 * use insertAnsweredQuestion(answeredQuestion) 
	 * to insert one by one
	 * @param answeredQuestions
	 * 						return boolean for testing
	 */
	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions);
}
