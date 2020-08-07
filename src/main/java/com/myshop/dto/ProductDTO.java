package com.myshop.dto;

import java.util.Date;

public class ProductDTO {

	private Integer productId;
	private String producerName;
	private String productImage;
	private double productPrice;
	private Integer productSale;
	private String content;
	private String productDescription;
	private Boolean productStatus;
	private Date createDate;
	private int accountId;
	private int categoryId;
	private int producerId;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductSale() {
		return productSale;
	}
	public void setProductSale(Integer productSale) {
		this.productSale = productSale;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Boolean getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProducerId() {
		return producerId;
	}
	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}
	
}
