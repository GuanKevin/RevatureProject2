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
	 * Return all answered Questions 
	 * from a specific taken test
	 * @param takenTest
	 * @return
	 */
	public List<AnsweredQuestion> getQuestionsByTakenTestId(TakenExam takenExam);

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
