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
	 * a specific question will be returned 
	 * by the questions id
	 * @param questionId passed by the user
	 * @return a Question object
	 */
	public Question getQuestionByQuestionId(int questionId);
	
	/**
	 * save a new question
	 * @param question
	 */
	public boolean insertQuestion(Question question);
	
	/**
	 * save a list of questions
	 * @param questions
	 *  					returns boolean for now for testing
	 */
	public boolean insertQuestions(List<Question> questions);
}
