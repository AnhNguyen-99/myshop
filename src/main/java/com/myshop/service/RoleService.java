package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.RoleDAO;
import com.myshop.entity.Role;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	public List<Role> getAll(){
		return roleDAO.getAll();
	}
}
