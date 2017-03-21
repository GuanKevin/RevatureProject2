package com.mathMaster.domain;

import java.util.List;

import com.mathMaster.model.Question;

/**
 * This interface will be used for the QuestionDAOImpl
 * @author Denise
 *
 */
public interface QuestionDAO {
	
	/**
	 * 
	 * @param questionId passed by the user
	 * @return a Question object
	 */
	public Question getQuestionByQuestionId(int questionId);
	
	/**
	 * 
	 * @param question
	 */
	public void insertQuestion(Question question);
	
	/**
	 * 
	 * @param questions
	 */
	public void insertQuestions(List<Question> questions);

	/**
	 * 
	 * @param testId
	 * @return
	 */
	public List<Question> getQuestionsByTestId(int testId);
	
}
