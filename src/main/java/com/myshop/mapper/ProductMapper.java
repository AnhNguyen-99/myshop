package com.myshop.mapper;

import com.myshop.dto.ProductDTO;
import com.myshop.entity.Product;

public class ProductMapper {

	public ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProducerName(product.getProducerName());;
		productDTO.setProductImage(product.getProductImage());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setProductSale(product.getProductSale());
		productDTO.setContent(product.getContent());
		productDTO.setProductDescription(product.getProductDescription());
		productDTO.setProductStatus(product.getProductStatus());
		productDTO.setCreateDate(product.getCreateDate());
		productDTO.setAccountId(product.getAccount().getAccountId());
		productDTO.setCategoryId(product.getCategory().getCategoryId());;
		productDTO.setProducerId(product.getProducer().getProducerId()); 
		return productDTO;
	}
}
