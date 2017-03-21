/**
 * 
 */
package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.util.M2SessionFactory;

/**
 * @author kevgu
 *
 */
public class GetTeacher {

	@Test
	public void getATeacherFromTheDatabase() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		TeacherDAO teacher = new TeacherDAOImpl(session);
		
		System.out.println(teacher.getTeacherByUserName("Code_Blooded_KG"));
	}

}
