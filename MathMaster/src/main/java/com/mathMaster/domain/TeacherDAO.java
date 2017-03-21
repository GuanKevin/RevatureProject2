package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.Teacher;

public interface TeacherDAO {
	public Teacher getTeacherByUserName(String username);
	public String getPassword(Teacher teacher);
	public void createTeacher(Teacher teacher, Session session);
}
