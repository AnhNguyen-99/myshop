package com.myshop.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productImage")
	private String productImage;
	
	@Column(name = "productImage2")
	private String productImage2;
	
	@Column(name = "productImage3")
	private String productImage3;
	
	@Column(name = "productPrice")
	private Double productPrice;
	
	@Column(name = "productSale")
	private int productSale;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "shortdescription")
	private String shortdescription;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private Category categoryId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producerId", referencedColumnName = "producerId")
	private Producer producerId;
	
	@OneToMany(mappedBy = "productId")
	public Collection<OrderItem> orderItem;

	public Product() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductSale() {
		return productSale;
	}

	public void setProductSale(int productSale) {
		this.productSale = productSale;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Producer getProducerId() {
		return producerId;
	}

	public void setProducerId(Producer producerId) {
		this.producerId = producerId;
	}

	public Collection<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Collection<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productImage2=" + productImage2 + ", productImage3=" + productImage3 + ", productPrice="
				+ productPrice + ", productSale=" + productSale + ", unit=" + unit + ", shortdescription="
				+ shortdescription + ", description=" + description + ", createDate=" + createDate + ", categoryId="
				+ categoryId + ", producerId=" + producerId + ", orderItem=" + orderItem + "]";
	}
	
}
