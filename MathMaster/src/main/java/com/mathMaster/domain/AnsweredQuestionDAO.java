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
	 * 
	 * @param takenTestId
	 * @return
	 */
	public List<AnsweredQuestion> getQuestionsByTakenTestId(int takenTestId);
}
