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
	 * Return all answered Questions 
	 * from a specific taken test
	 * @param takenTestId
	 * @return
	 */
	public List<AnsweredQuestion> getQuestionsByTakenTestId(int takenTestId);
}
