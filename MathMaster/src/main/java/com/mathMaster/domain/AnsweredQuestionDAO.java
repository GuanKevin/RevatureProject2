package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.AnsweredQuestion;

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
	 * @param answeredQuestions
	 * 						return boolean for testing
	 */
	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions);
}
