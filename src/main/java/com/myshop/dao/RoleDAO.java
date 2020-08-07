package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Role;

@Repository(value = "roleDAO")
@Transactional(rollbackFor = Exception.class)
public class RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Role> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Role", Role.class).getResultList();
	}
}
