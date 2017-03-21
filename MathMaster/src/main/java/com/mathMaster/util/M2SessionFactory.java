package com.mathMaster.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class M2SessionFactory {
	private static SessionFactory sessionFactory;
	
	public synchronized static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			createSessionFactory();
		return sessionFactory;
	}
	
	public static void createSessionFactory() {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
	}
}
