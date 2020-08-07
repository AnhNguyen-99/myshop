package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.ProducerDAO;
import com.myshop.entity.Producer;

@Service
@Transactional
public class ProducerService {

	@Autowired
	private ProducerDAO producerDAO;
	
	public boolean save(final Producer producer) {
		return producerDAO.save(producer);
	}
	
	public boolean update(final Producer producer) {
		return producerDAO.update(producer);
	}
	
	public boolean delete(final Producer producer) {
		return producerDAO.delete(producer);
	}
	
	public List<Producer> getAll(){
		return producerDAO.getAll();
	}
	
	public Producer findById(int producerId) {
		return producerDAO.findById(producerId);
	}

}
