package com.myshop.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.News;

@Repository(value = "newsDAO")
@Transactional(rollbackFor = Exception.class)
public class NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean create(News obj) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
    
    public boolean update(News obj) {
    	Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
    }
    
    public boolean delete(News obj) {
    	Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
    }
    
    public News findById(Integer newsId) {
    	Session session = this.sessionFactory.getCurrentSession();
    	return session.get(News.class, newsId);
    }
    
    public List<News> getAll(){
    	Session session = this.sessionFactory.getCurrentSession();
    	return session.createQuery("FROM News", News.class).getResultList();
    }
    
    
}
