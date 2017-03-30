package com.mathMaster.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.TakenExam;

@Repository
public class TakenExamDAOImpl implements TakenExamDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public TakenExamDAOImpl() {
		super();
	}

	@Transactional
	public TakenExam getTakenExamById(int takenExamId) {
		return (TakenExam) sessionFactory.getCurrentSession().get(TakenExam.class, takenExamId);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public void createTakenExam(TakenExam takenExam) {
		System.out.println("saving");
		System.out.println(takenExam);
		sessionFactory.getCurrentSession().saveOrUpdate(takenExam);
		System.out.println("save complete");
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean updateScore(TakenExam takenExam, int score) {
		takenExam.setScore(score);
		sessionFactory.getCurrentSession().update(takenExam);
		return true;
	}

}
