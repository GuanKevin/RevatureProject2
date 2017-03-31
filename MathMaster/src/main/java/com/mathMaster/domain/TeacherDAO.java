package com.mathMaster.domain;

import org.hibernate.SessionFactory;

import com.mathMaster.model.Teacher;

public interface TeacherDAO {
	public void setSessionFactory(SessionFactory sessionFactory);
	public Teacher getTeacherByUserName(String username);
	public boolean createTeacher(Teacher teacher);
	public boolean removeTeacher(Teacher teacher);
}
