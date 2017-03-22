package com.mathMaster.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mathMaster.domain.AnsweredQuestionDAOImpl;
import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Question;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;

public class DeniseFacade{
	private SessionFactory sf = M2SessionFactory.getSessionFactory();
	private Session session = sf.openSession();
	private TeacherDAO teacherDAO;
	private Teacher teacher;
	private StudentDAO studentDAO;
	private Student student;
	private boolean user; //true = teacher, false = student
	
	
	
	
	
	/**
	 * DENISE CODE for facade!!!!!!
	 */
	
	private AnsweredQuestionDAOImpl answeredQuestionDAO;
	private QuestionDAOImpl questionDAO;
	
	public boolean insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		return answeredQuestionDAO.insertAnsweredQuestion(answeredQuestion);
	}

	public boolean insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		return answeredQuestionDAO.insertAnsweredQuestions(answeredQuestions);
	}

	public Question getQuestionByQuestionId(int questionId) {
		return questionDAO.getQuestionByQuestionId(questionId);
	}

	public boolean insertQuestion(Question question) {
		return new QuestionDAOImpl(session).insertQuestion(question);
	}

	public boolean insertQuestions(List<Question> questions) {
		return questionDAO.insertQuestions(questions);
	}
}
