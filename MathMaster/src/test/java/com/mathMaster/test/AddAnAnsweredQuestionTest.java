package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.AnsweredQuestionDAOImpl;
import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.domain.TakenExamDAOImpl;
import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Question;
import com.mathMaster.model.TakenExam;
import com.mathMaster.util.M2SessionFactory;

public class AddAnAnsweredQuestionTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		Question question = new QuestionDAOImpl(session).getQuestionByQuestionId(1);
		TakenExam takenExam = new TakenExamDAOImpl(session).getTakenExamById(1);
		AnsweredQuestion answeredQuestion = new AnsweredQuestion("right answer", question, takenExam);
		
		System.out.println(new AnsweredQuestionDAOImpl(session).insertAnsweredQuestion(answeredQuestion));

		session.close();
		sf.close();
	}

}
