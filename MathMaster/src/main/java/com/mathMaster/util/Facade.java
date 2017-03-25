package com.mathMaster.util;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mathMaster.domain.AnsweredQuestionDAO;
import com.mathMaster.domain.CourseDAO;
import com.mathMaster.domain.ExamDAO;
import com.mathMaster.domain.QuestionDAO;
import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.TakenExamDAO;
import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.model.Teacher;

@Component(value="facade")
public class Facade implements AutoCloseable {
	private AnsweredQuestionDAO answeredQuestionDAO;
	private CourseDAO courseDAO;
	private ExamDAO examDAO;
	private SessionFactory sf;
	private StudentDAO studentDAO;
	private TakenExamDAO takenExamDAO;
	private TeacherDAO teacherDAO;
	private QuestionDAO questionDAO;

	public Facade() {
		sf = new Configuration().configure().buildSessionFactory();;
	}

	/**
	 * isTeacher is a boolean variable that takes in true if the user that is
	 * trying to sign in enter the buttons as a teacher, otherwise, it is false
	 * and assumed that the user that is trying to sign in is a student. The
	 * user is then verified by looking for the username in the teacher or
	 * student table in the database and finally, their hashed password is
	 * checked with the password entered.
	 * 
	 * @param isTeacher
	 * @param username
	 * @param password
	 */
	/*public void login(boolean isTeacher, String username, String password) {
		boolean user = isTeacher;

		if (username != null && password != null)
			user = isTeacher;
		else
		// TODO User is missing username or password field and need to fill it

		if (user) {
			Teacher teacher;
			teacher = teacherDAO.getTeacherByUserName(username);

			if (teacher != null) {
				if (!BCrypt.checkpw(password, teacher.getPassword())) {
					// Gets in here if password entered does not matches the
					// password
					// found in the database that is related to the username
					// TODO Don't allow teacher to login
				}
				else {
					System.out.println(teacher.getUserName() + " logged in");
				}
			}
		} else {
			Student student;
			student = studentDAO.getStudentByUsername(username);

			if (student != null) {
				if (!BCrypt.checkpw(password, student.getPassword())) {
					// Gets in here if password entered does not matches the
					// password
					// found in the database that is related to the username
					// TODO Don't allow teacher to login
				}
			}
		}
	}*/

	public Teacher getTeacherByUserName(String username) {
		Session session = sf.openSession();
		teacherDAO.setSession(session);
		Teacher teacher = teacherDAO.getTeacherByUserName(username);
		session.close();
		return teacher;
	}

	public void createTeacher(Teacher teacher) {
		Session session = sf.openSession();
		teacherDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			teacherDAO.createTeacher(teacher);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}
	
	public void removeTeacher(Teacher teacher) {
		Session session = sf.openSession();
		teacherDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			teacherDAO.removeTeacher(teacher);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}
	
	public Exam getExamById(int examId) {
		Session session = sf.openSession();
		examDAO.setSession(session);
		Exam exam = examDAO.getExamById(examId);
		session.close();
		return exam;
	}

	public void createExam(Exam exam) {
		Session session = sf.openSession();
		examDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			examDAO.createExam(exam);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public TakenExam getTakenExamById(int takenExamId) {
		Session session = sf.openSession();
		takenExamDAO.setSession(session);
		System.out.println("Here");
		System.out.println(takenExamDAO.getTakenExamById(takenExamId));
		TakenExam exam = takenExamDAO.getTakenExamById(takenExamId);
		session.close();
		return exam;
	}

	public void takeExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		Session session = sf.openSession();
		takenExamDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			takenExamDAO.takeExam(exam, student, score, timeTaken);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public void updateScore(TakenExam takenExam, int score) {
		Session session = sf.openSession();
		takenExamDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			takenExamDAO.updateScore(takenExam, score);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public void createCourse(Course course) {
		Session session = sf.openSession();
		courseDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			courseDAO.createCourse(course);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public Course getCourseById(int id) {
		Session session = sf.openSession();
		courseDAO.setSession(session);
		Course course = courseDAO.getCourseById(id);
		session.close();
		return course;
	}

	public Student getStudentByUsername(String username) {
		Session session = sf.openSession();
		studentDAO.setSession(session);
		Student student = studentDAO.getStudentByUsername(username);
		session.close();
		return student;
	}

	public void createStudent(Student student) {
		Session session = sf.openSession();
		studentDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			studentDAO.createStudent(student);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public void removeStudent(Student student) {
		Session session = sf.openSession();
		studentDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			studentDAO.removeStudent(student);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public void insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		Session session = sf.openSession();
		answeredQuestionDAO.setSession(session);
		answeredQuestionDAO.insertAnsweredQuestion(answeredQuestion);
		session.close();
	}

	public void insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		Session session = sf.openSession();
		answeredQuestionDAO.setSession(session);
		answeredQuestionDAO.insertAnsweredQuestions(answeredQuestions);
		session.close();
	}

	public Question getQuestionByQuestionId(int questionId) {
		Session session = sf.openSession();
		questionDAO.setSession(session);
		Question question = questionDAO.getQuestionByQuestionId(questionId);
		session.close();
		return question;
	}

	public void insertQuestion(Question question) {
		Session session = sf.openSession();
		questionDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			questionDAO.insertQuestion(question);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public void insertQuestions(List<Question> questions) {
		Session session = sf.openSession();
		questionDAO.setSession(session);
		Transaction tx = session.beginTransaction();
		try{
			questionDAO.insertQuestions(questions);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		session.close();
	}	
	
	@Autowired
	public void setAnsweredQuestionDAO(AnsweredQuestionDAO answeredQuestionDAO) {
		this.answeredQuestionDAO = answeredQuestionDAO;
	}

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Autowired
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Autowired
	public void setTakenExamDAO(TakenExamDAO takenExamDAO) {
		this.takenExamDAO = takenExamDAO;
	}

	@Autowired
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Autowired
	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	/**
	 * TODO Figure out where all the sessions and the sessionfactory should be
	 * called
	 */
	public void close() throws Exception {
		sf.close();
	}
}
