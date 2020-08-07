package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.ProductDTO;
import com.myshop.service.ProductService;

@RestController
@RequestMapping(value = "api/product")
public class ProductAPI {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<ProductDTO>> listProduct(){
		List<ProductDTO> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable int id){
		ProductDTO productDTO = productService.getById(id);
		return ResponseEntity.ok().body(productDTO);
	}
}
