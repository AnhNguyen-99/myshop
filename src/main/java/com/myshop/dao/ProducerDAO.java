package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Producer;

@Repository(value = "producerDAO")
@Transactional(rollbackFor = Exception.class)
public class ProducerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean create(final Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public Producer findById(int producerId) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Producer) session.createQuery("FROM Producer WHERE producerId =:producerId").setInteger("producerId", producerId);
	}
	
	public List<Producer>getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Producer").list();
	}
	
}
