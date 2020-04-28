package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.CategoryDAO;
import com.myshop.entity.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public boolean save(final Category category) {
		return categoryDAO.save(category);
	}
	
	public void update(final Category category) {
		categoryDAO.update(category);
	}
	
	public void delete(final Category category) {
		categoryDAO.delete(category);
	}
	
	public Category findById(final int categoryId) {
		return categoryDAO.findById(categoryId);
	}
	
	public List<Category> findAll(){
		return categoryDAO.findAll();
	}
	
}
