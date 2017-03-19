package com.mathMaster.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Denise
 *
 */

@Entity
@Table(name = "M2_STUDENT_COURSE")
@NamedQueries({

})
@NamedNativeQueries({

})
public class StudentCourse {
	@Id
	@Column(name = "STUDENT_COURSE_ID")
	@SequenceGenerator(name = "STUDENT_COURSE", sequenceName = "STUDENT_COURSE_PK_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "STUDENT_COURSE", strategy = GenerationType.SEQUENCE)
	private int studentCourseId;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private User studentId;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Course courseId;

	public StudentCourse() {}

	public StudentCourse(int studentCourseId, User studentId, Course courseId) {
		super();
		this.studentCourseId = studentCourseId;
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(int studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public User getStudentId() {
		return studentId;
	}

	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentCourse [studentCourseId=" + studentCourseId + ", studentId=" + studentId + ", courseId="
				+ courseId + "]";
	}
}
