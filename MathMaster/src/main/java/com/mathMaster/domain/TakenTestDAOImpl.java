package com.mathMaster.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Student;
import com.mathMaster.model.TakenTest;

public class TakenTestDAOImpl implements TakenTestDAO{
	Session session;
	
	public TakenTestDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<TakenTest> getAllTakenTest(Student student) {
		Criteria criteria = session.createCriteria(TakenTest.class);
		return criteria.add(Restrictions.eq("STUDENT_ID", student.getStudentId())).list();
	}

	public TakenTest getTakenTestById(int takenTestId) {
		Criteria criteria = session.createCriteria(TakenTest.class);
		return (TakenTest) criteria.add(Restrictions.eq("TAKEN_TEST_ID", takenTestId)).uniqueResult();
	}

	public boolean takeTest(TakenTest takenTest) {
		Transaction tx = session.beginTransaction();
		try{
			session.save(takenTest);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}
