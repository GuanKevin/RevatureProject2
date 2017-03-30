package com.mathMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.AnsweredQuestion;
import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.model.Question;
import com.mathMaster.model.Student;
import com.mathMaster.model.TakenExam;
import com.mathMaster.model.Teacher;

@Service(value="businessDelegate")
public class Delegate {
	private AnsweredQuestionService answeredQuestionService;
	private CourseService courseService;
	private ExamService examService;
	private QuestionService questionService;
	private StudentService studentService;
	private TakenExamService takenExamService;
	private TeacherService teacherService;
	
	public Exam getExamById(int examId) {
		return examService.getExamById(examId);
	}

	public void insertAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		answeredQuestionService.insertAnsweredQuestion(answeredQuestion);
	}

	public void insertAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		System.out.println("[     IN DELEGATE    ]");
		answeredQuestionService.insertAnsweredQuestions(answeredQuestions);
		System.out.println("[    EXITING DELEGATE   ]");
	}
	
	public Course getCourseById(int id) {
		return courseService.getCourseById(id);
	}
	
	public void createCourse(Course course) {
		courseService.createCourse(course);
	}
	
	public void createExam(Exam exam) {
		examService.createExam(exam);
	}
	
	public Question getQuestionByQuestionId(int questionId) {
		return questionService.getQuestionByQuestionId(questionId);
	}

	public void insertQuestion(Question question) {
		questionService.insertQuestion(question);
	}

	public void insertQuestions(List<Question> questions) {
		System.out.println("[     IN DELEGATE    ]");
		questionService.insertQuestions(questions);
		System.out.println("[    EXITING DELEGATE   ]");
	}	
	
	public Student getStudentByUsername(String username) {
		return studentService.getStudentByUsername(username);
	}

	public void createStudent(Student student) {
		studentService.createStudent(student);
	}

	public void removeStudent(Student student) {
		studentService.removeStudent(student);
	}
	
	public TakenExam getTakenExamById(int id) {
		return takenExamService.getTakenExamById(id);
	}
	
	public void createTakenExam(TakenExam takenExam) {
		takenExamService.createTakenExam(takenExam);
	}

	public void updateScore(TakenExam takenExam, int score) {
		takenExamService.updateScore(takenExam, score);
	}
	
	public Teacher getTeacherByUserName(String username) {
		return teacherService.getTeacherByUserName(username);
	}

	public void createTeacher(Teacher teacher) {
		teacherService.createTeacher(teacher);
	}
	
	public void removeTeacher(Teacher teacher) {
		teacherService.removeTeacher(teacher);
	}
	
	// Setters
	
	@Autowired
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@Autowired
	public void setTakenExamService(TakenExamService takenExamService) {
		this.takenExamService = takenExamService;
	}

	@Autowired
	public void setAnsweredQuestionService(AnsweredQuestionService answeredQuestionService) {
		this.answeredQuestionService = answeredQuestionService;
	}

	@Autowired
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
}
