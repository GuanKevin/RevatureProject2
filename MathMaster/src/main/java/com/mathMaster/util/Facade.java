package com.mathMaster.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Facade implements AutoCloseable {
	private SessionFactory sf = M2SessionFactory.getSessionFactory();
	private Session session;
	
	
	
	public void close() throws Exception {
		sf.close();
		session.close();
	}
}
