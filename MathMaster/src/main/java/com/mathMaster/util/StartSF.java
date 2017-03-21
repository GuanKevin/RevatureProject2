package com.mathMaster.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StartSF {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure()
				.buildSessionFactory();
		sf.close();
	}
}
