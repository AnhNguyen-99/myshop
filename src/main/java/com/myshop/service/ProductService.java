package com.myshop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.ProductDAO;
import com.myshop.dto.ProductDTO;
import com.myshop.entity.Product;
import com.myshop.mapper.ProductMapper;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public boolean save(final Product product) {
		return productDAO.save(product);
	}
	
	public boolean update(final Product product) {
		return productDAO.update(product);
	}
	
	public boolean delete(final Product product) {
		return productDAO.delete(product);
	}
	
	public List<Product> getAll(){
		return productDAO.getAll();
	}
	
	public Product findById(int productId) {
		return productDAO.findById(productId);
	}
	
	public List<Product> findByName(String productName){
		return productDAO.findByName(productName);
	}
	
	public List<ProductDTO> findAll(){
		List<ProductDTO> listDTO = new ArrayList<>();
		List<Product> list = productDAO.getAll();
		for(Product product: list) {
			ProductMapper productMapper = new ProductMapper();
			ProductDTO productDTO = productMapper.toProductDTO(product);
			listDTO.add(productDTO);
		}
		return listDTO;
	}
	
	public ProductDTO getById(int productId) {
		Product product = productDAO.findById(productId);
		ProductMapper productMapper = new ProductMapper();
		ProductDTO productDTO = productMapper.toProductDTO(product);
		return productDTO;
	}
}
