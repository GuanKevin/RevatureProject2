package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.Teacher;

public interface TeacherDAO {
	public Teacher getTeacherByUserName(String username);
	public boolean createTeacher(Teacher teacher);
	public boolean removeTeacher(Teacher teacher);
	public void setSession(Session session);
}
