package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Feedback;

@Repository(value = "feedBackDAO")
@Transactional(rollbackFor = Exception.class)
public class FeedBackDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(final Feedback feedback) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(feedback);
			session.flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Feedback> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Feedback", Feedback.class).getResultList();
	}
}
