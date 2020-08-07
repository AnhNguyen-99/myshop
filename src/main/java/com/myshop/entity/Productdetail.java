package com.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productdetail", catalog = "myshop")
public class Productdetail implements java.io.Serializable {

	private static final long serialVersionUID = -4328995011502431496L;
	
	private int productDetailId;
	private Color color;
	private Product product;
	private Sizes sizes;

	public Productdetail() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productDetailId", unique = true, nullable = false)
	public int getProductDetailId() {
		return this.productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colorId", nullable = false)
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sizeId", nullable = false)
	public Sizes getSizes() {
		return this.sizes;
	}

	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}

}
