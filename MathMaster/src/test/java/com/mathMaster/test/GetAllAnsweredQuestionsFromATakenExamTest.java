/**
 * 
 */
package com.mathMaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Question;
import com.mathMaster.util.M2SessionFactory;

/**
 * @author Denise
 *
 */
public class GetAllAnsweredQuestionsFromATakenExamTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		Set<AnsweredQuestion> answeredQuestions = new QuestionDAOImpl(session).getExamById(4).getQuestions();
		
		for(AnsweredQuestion aq : answeredQuestions){
			System.out.println(aq);
		}	
	}

}
