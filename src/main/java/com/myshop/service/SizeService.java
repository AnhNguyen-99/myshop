package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.SizeDAO;
import com.myshop.entity.Sizes;

@Service
@Transactional
public class SizeService {

	@Autowired
	private SizeDAO sizeDAO;
	
	public boolean save(final Sizes sizes) {
		return sizeDAO.save(sizes);
	}
	
	public boolean update(final Sizes sizes) {
		return sizeDAO.update(sizes);
	}
	
	public boolean delete(final Sizes sizes) {
		return sizeDAO.delete(sizes);
	}
	
	public List<Sizes> getAll(){
		return sizeDAO.getAll();
	}
	
	public Sizes findById(int sizeId) {
		return sizeDAO.findById(sizeId);
	}
}
