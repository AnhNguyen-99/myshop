package com.myshop.mapper;

import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Category;

public class CategoryMapper {

	public CategoryDTO toCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setCategoryStatus(category.getCategoryStatus());
		categoryDTO.setCreateDate(category.getCreateDate());
		categoryDTO.setAccountId(category.getAccount().getAccountId());
		return categoryDTO;
	}
	
	public Category toCategoryEntity(Category category, CategoryDTO categoryDTO) {
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setCategoryStatus(categoryDTO.getCategoryStatus());
		category.setCreateDate(categoryDTO.getCreateDate());
		Account account = new Account(categoryDTO.getAccountId());
		category.setAccount(account);
		return category;
	}
}
