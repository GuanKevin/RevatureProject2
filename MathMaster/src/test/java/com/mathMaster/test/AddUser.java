package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.mathMaster.model.User;
import com.mathMaster.model.UserRole;
import com.mathMaster.util.M2SessionFactory;

public class AddUser {

	@Test
	public void addAUserToM2_UserTable() {
		Session s = M2SessionFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		UserRole role = (UserRole) s.load(UserRole.class, 2);
		s.save(new User("KevinGuan", "welcome1", "Kevin", "Guan", role, "kg@gmail.com"));
		tx.commit();
	}
	
	
}
