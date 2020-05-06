package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product", catalog = "myshop_1")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1334218165006061223L;

	private Integer productId;
	private Category category;
	private Producer producer;
	private String productName;
	private String productImage;
	private String productImage2;
	private String productImage3;
	private float productPrice;
	private int productSale;
	private String unit;
	private String shortdescription;
	private String description;
	private Date createDate;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

	public Product() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productId", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producerId", nullable = false)
	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@Column(name = "productName", nullable = false)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "productImage", nullable = false)
	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Column(name = "productImage2", nullable = false)
	public String getProductImage2() {
		return this.productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	@Column(name = "productImage3", nullable = false)
	public String getProductImage3() {
		return this.productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	@Column(name = "productPrice", nullable = false, precision = 12, scale = 0)
	public float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "productSale", nullable = false)
	public int getProductSale() {
		return this.productSale;
	}

	public void setProductSale(int productSale) {
		this.productSale = productSale;
	}

	@Column(name = "unit", length = 20)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "shortdescription")
	public String getShortdescription() {
		return this.shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderItem> getOrderitems() {
		return this.orderItems;
	}

	public void setOrderitems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
