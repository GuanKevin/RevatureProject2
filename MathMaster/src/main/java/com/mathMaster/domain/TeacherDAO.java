package com.mathMaster.domain;

import com.mathMaster.model.Teacher;

public interface TeacherDAO {
	public Teacher getTeacherByUserName(String username);
	public void createTeacher(Teacher teacher);
}
