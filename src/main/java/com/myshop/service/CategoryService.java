package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.CategoryDAO;
import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Category;
import com.myshop.mapper.CategoryMapper;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	public boolean save(final Category category) {
		return categoryDAO.save(category);
	}
	
	public boolean update(final Category category) {
		return categoryDAO.update(category);
	}
	
	public boolean delete(final Category category) {
		return categoryDAO.delete(category);
	}
	
	public List<Category> getAll(){
		return categoryDAO.getAll();
	}
	
	public Category findById(int categoryId) {
		return categoryDAO.findById(categoryId);
	}
	
	public List<CategoryDTO> findAll(){
		List<CategoryDTO> listDTO = new ArrayList<>();
		List<Category> list = categoryDAO.getAll();
		for(Category item: list) {
			CategoryMapper categoryMapper = new CategoryMapper();
			CategoryDTO categoryDTO  = categoryMapper.toCategoryDTO(item);
			listDTO.add(categoryDTO);
		}
		return listDTO;
	}
	
	public CategoryDTO getById(int categoryId) {
		Category category = categoryDAO.findById(categoryId);
		CategoryMapper categoryMapper = new CategoryMapper();
		CategoryDTO categoryDTO  = categoryMapper.toCategoryDTO(category);
		return categoryDTO;
	}
	
	public boolean saveDTO(CategoryDTO categoryDTO) {
		CategoryMapper categoryMapper = new CategoryMapper();
		Category category1 = new Category();
		Category category = new Category();
		category = categoryMapper.toCategoryEntity(category1, categoryDTO);
		return categoryDAO.save(category);
	}
}
