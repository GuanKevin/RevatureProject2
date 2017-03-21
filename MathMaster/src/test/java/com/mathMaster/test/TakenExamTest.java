package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.TakenExamDAOImpl;
import com.mathMaster.util.M2SessionFactory;

public class TakenExamTest {
	@Test
	public void sets() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session s = sf.openSession();
		
		TakenExamDAOImpl dao = new TakenExamDAOImpl(s);
		
		System.out.println(dao.getTakenExamById(1));
	}
}
