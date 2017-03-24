package com.mathMaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.model.Question;
import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

/**
 * Returns a list of Question from a specific Exam
 * Closes all Sessions and Facade after all work is done
 * 
 * @authors Denise, kevgu
 *
 */
public class GetAllExamQuestion {
	private static SessionFactory sf;
	private static Session session;
	private static Facade facade;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
		facade = new Facade();		
	}
	
	@Test
	public void GetAllTheExamQuestionFromASpecificExam() {
		Set<Question> questionList = facade.getExamById(24).getQuestions();
		
		for (Question q: questionList) 
			System.out.println(q);
	}
	
	@AfterClass
	public static void closingAllSession() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetAllExamQuestion test.");
			e.printStackTrace();
		}
	}

}
