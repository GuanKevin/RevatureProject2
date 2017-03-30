package com.mathMaster.util;

import java.util.List;

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

@Component
public class Facade {
	private AnsweredQuestionDAO answeredQuestionDAO;
	private CourseDAO courseDAO;
	private ExamDAO examDAO;
/*	private SessionFactory sf;
*/	private StudentDAO studentDAO;
	private TakenExamDAO takenExamDAO;
	private TeacherDAO teacherDAO;
	private QuestionDAO questionDAO;

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
	/*
	 * public void login(boolean isTeacher, String username, String password) {
	 * boolean user = isTeacher;
	 * 
	 * if (username != null && password != null) user = isTeacher; else // TODO
	 * User is missing username or password field and need to fill it
	 * 
	 * if (user) { Teacher teacher; teacher =
	 * teacherDAO.getTeacherByUserName(username);
	 * 
	 * if (teacher != null) { if (!BCrypt.checkpw(password,
	 * teacher.getPassword())) { // Gets in here if password entered does not
	 * matches the // password // found in the database that is related to the
	 * username // TODO Don't allow teacher to login } else {
	 * System.out.println(teacher.getUserName() + " logged in"); } } } else {
	 * Student student; student = studentDAO.getStudentByUsername(username);
	 * 
	 * if (student != null) { if (!BCrypt.checkpw(password,
	 * student.getPassword())) { // Gets in here if password entered does not
	 * matches the // password // found in the database that is related to the
	 * username // TODO Don't allow teacher to login } } } }
	 */
//	public Student authStudent(String username, String password){
//		Session session = sf.openSession();
//		studentDAO.setSession(session);
//		Student student = studentDAO.getStudentByUsername(username);
//		
//		if(BCrypt.checkpw(password, student.getPassword())){
//			return student;
//		}
//		return null;
//	}
	public Teacher getTeacherByUserName(String username) {
		return teacherDAO.getTeacherByUserName(username);
	}

	public void createTeacher(Teacher teacher) {
		teacherDAO.createTeacher(teacher);

	}

	public void removeTeacher(Teacher teacher) {
		teacherDAO.removeTeacher(teacher);

	}

	public Exam getExamById(int examId) {
		return examDAO.getExamById(examId);
	}

	public void createExam(Exam exam) {
		examDAO.createExam(exam);
	}

	public TakenExam getTakenExamById(int takenExamId) {

		System.out.println("Here");
		System.out.println(takenExamDAO.getTakenExamById(takenExamId));

		return takenExamDAO.getTakenExamById(takenExamId);
	}

	public void createTakenExam(TakenExam takenExam) {
		takenExamDAO.createTakenExam(takenExam);

	}

	public void updateScore(TakenExam takenExam, int score) {
		takenExamDAO.updateScore(takenExam, score);
	}

	public void createCourse(Course course) {
		courseDAO.createCourse(course);
	}

	public Course getCourseById(int id) {
		return courseDAO.getCourseById(id);
	}

	public Student getStudentByUsername(String username) {
		return  studentDAO.getStudentByUsername(username);
	}

	public void createStudent(Student student) {
		studentDAO.createStudent(student);
	}

	public void removeStudent(Student student) {
		studentDAO.removeStudent(student);
	}

	public void insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		answeredQuestionDAO.insertAnsweredQuestion(answeredQuestion);
	}

	public void insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		System.out.println("[       IN THE FACADE   ]");

		answeredQuestionDAO.insertAnsweredQuestions(answeredQuestions);

		System.out.println("[       EXITING THE FACADE   ]");
	}

	public Question getQuestionByQuestionId(int questionId) {
		return questionDAO.getQuestionByQuestionId(questionId);
	}

	public void insertQuestion(Question question) {
		questionDAO.insertQuestion(question);
	}

	public void insertQuestions(List<Question> questions) {
		System.out.println("[       IN THE FACADE   ]");
		questionDAO.insertQuestions(questions);
		System.out.println("[       EXITING THE FACADE   ]");

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

}
