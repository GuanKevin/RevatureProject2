package com.mathMaster.util;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.AnsweredQuestionDAO;
import com.mathMaster.domain.AnsweredQuestionDAOImpl;
import com.mathMaster.domain.CourseDAO;
import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.ExamDAO;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.domain.QuestionDAO;
import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.domain.TakenExamDAO;
import com.mathMaster.domain.TakenExamDAOImpl;
import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.model.Teacher;

public class Facade implements AutoCloseable {
	private AnsweredQuestionDAO answeredQuestionDAO;
	private CourseDAO courseDAO;
	private ExamDAO examDAO;
	private SessionFactory sf;
	private Session session;
	private StudentDAO studentDAO;
	private TakenExamDAO takenExamDAO;
	private TeacherDAO teacherDAO;
	private QuestionDAO questionDAO;

	public Facade() {
		try {
			sf = M2SessionFactory.getSessionFactory();
			session = sf.openSession();

			examDAO = new ExamDAOImpl(session);
			takenExamDAO = new TakenExamDAOImpl(session);
			teacherDAO = new TeacherDAOImpl(session);
			studentDAO = new StudentDAOImpl(session);
			courseDAO = new CourseDAOImpl(session);
			answeredQuestionDAO = new AnsweredQuestionDAOImpl(session);
			questionDAO = new QuestionDAOImpl(session);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void login(boolean isTeacher, String username, String password) {
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
	}

	public Teacher getTeacherByUserName(String username) {
		return teacherDAO.getTeacherByUserName(username);
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

	public boolean takeExam(Exam exam, Student student, int score, Timestamp timeTaken) {
		return takenExamDAO.takeExam(exam, student, score, timeTaken);
	}

	public boolean updateScore(TakenExam takenExam, int score) {
		return takenExamDAO.updateScore(takenExam, score);
	}

	public boolean createCourse(Course course) {
		return courseDAO.createCourse(course);
	}

	public Course getCourseById(int id) {
		return courseDAO.getCourseById(id);
	}

	public Student getStudentByUsername(String username) {
		return studentDAO.getStudentByUsername(username);
	}

	public boolean createStudent(Student student) {
		return studentDAO.createStudent(student);
	}

	public boolean removeStudent(Student student) {
		return studentDAO.removeStudent(student);
	}

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
		return questionDAO.insertQuestion(question);
	}

	public boolean insertQuestions(List<Question> questions) {
		return questionDAO.insertQuestions(questions);
	}	
	/**
	 * TODO Figure out where all the sessions and the sessionfactory should be
	 * called
	 */
	public void close() throws Exception {
		sf.close();
		session.close();
	}
}
