package com.mathMaster.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Create database from beans in model package
 * Uses hibernate annotations
 *
 */
public class StartSF {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure()
				.buildSessionFactory();
		sf.close();
	}
}
