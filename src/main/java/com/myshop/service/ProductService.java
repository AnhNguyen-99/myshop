package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.ProductDAO;
import com.myshop.entity.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public boolean create(final Product product) {
		return productDAO.create(product);
	}
	
	public boolean update(final Product product) {
		return productDAO.update(product);
	}
	
	public void delete(final Product product) {
		productDAO.delete(product);
	}
	
	public List<Product> getAll(){
		return productDAO.getAll();
	}
	
	public Product findById(final int productId) {
		return productDAO.findById(productId);
	}
	
	public List<Product> getListBySale(int limit){
		return productDAO.getListBySale(limit);
	}
	
	public List<Product> getListByPrice(int limit){
		return productDAO.getListByPrice(limit);
	}
	
	public List<Product> getListNav(Integer offset, Integer maxResult){
		return productDAO.getListNav(offset, maxResult);
	}
	
	public int totalItem() {
		return productDAO.totalItem();
	}
	
	public List<Product> getListByCategoryAndLimit(Integer categoryId, Integer offset, Integer maxResalt){
		return productDAO.getListByCategoryAndLimit(categoryId, offset, maxResalt);
	}
	
	public int totalProductByCategoryId(Integer categoryId) {
		return productDAO.totalProductByCategoryId(categoryId);
	}
	
	public List<Product> getListByProductName(String productName){
		return productDAO.getListByProductName(productName);
	}
	
	public List<Product> getListByCategoryId(Integer categoryId){
		return productDAO.getListByCategoryId(categoryId);
	}
	
}
