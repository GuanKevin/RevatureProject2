package com.mathMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Course;
import com.mathMaster.util.Facade;

@Service
public class CourseService {
	private Facade facade;
	
	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}

	Course getCourseById(int id) {
		return facade.getCourseById(id);
	}
	
	public void createCourse(Course course) {
		facade.createCourse(course);
	}
}
