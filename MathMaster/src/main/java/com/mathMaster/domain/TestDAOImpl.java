package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Test;

public class TestDAOImpl implements TestDAO{
	private Session session;
	
	public TestDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Test> getAllTest(int courseId) {
		Criteria criteria = session.createCriteria(Test.class);
		return criteria.add(Restrictions.eq("course", courseId)).list();
	}

	public Test getTestById(int testId) {
		Criteria criteria = session.createCriteria(Test.class);
		return (Test) criteria.add(Restrictions.eq("TEST_ID", testId)).uniqueResult();
	}

	public boolean createTest(Test test) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(test);
			tx.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	

}
