package com.mathMaster.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mathMaster.domain.ExamDAO;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.domain.TakenExamDAO;
import com.mathMaster.domain.TakenExamDAOImpl;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;

public class DFacade implements AutoCloseable{
	private SessionFactory sf;
	private Session session;
	private ExamDAO examDAO;
	private TakenExamDAO takenExamDAO;
	
	public DFacade() {
		try {
			sf = M2SessionFactory.getSessionFactory();
			session = sf.openSession();
			examDAO = new ExamDAOImpl(session);
			takenExamDAO = new TakenExamDAOImpl(session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Exam getExamById(int examId) {
		return examDAO.getExamById(examId);
	}
	
	public boolean createExam(Exam exam) {
		return examDAO.createExam(exam);
	}
	
	public TakenExam getTakenExamById(int takenExamId) {
		return takenExamDAO.getTakenExamById(takenExamId);
	}

	public boolean takeExam(Exam exam, Student student, int score, int timeTaken) {
		return takenExamDAO.takeExam(exam, student, score, timeTaken);
	}

	public boolean updateScore(TakenExam takenExam, int score) {
		return takenExamDAO.updateScore(takenExam, score);
	}
	
	// Usable with try-with-resources statement or call with statement
	public void close() throws Exception {
		if(sf != null)
			sf.close();
	}
}
