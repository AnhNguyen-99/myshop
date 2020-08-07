package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product", catalog = "myshop")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = -7281994946038357165L;

	private Integer productId;
	private Account account;
	private Category category;
	private Producer producer;
	private String producerName;
	private String productImage;
	private double productPrice;
	private Integer productSale;
	private String content;
	private String productDescription;
	private Boolean productStatus;
	private Date createDate;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);
	private Set<Productdetail> productdetails = new HashSet<Productdetail>(0);

	public Product() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
		this.productStatus = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	@Column(name = "producerName", nullable = false)
	public String getProducerName() {
		return this.producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	@Column(name = "productImage", nullable = false, length = 100)
	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Column(name = "productPrice", nullable = false, precision = 22, scale = 0)
	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "productSale")
	public Integer getProductSale() {
		return this.productSale;
	}

	public void setProductSale(Integer productSale) {
		this.productSale = productSale;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "productDescription", length = 65535)
	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "productStatus")
	public Boolean getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
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
	public Set<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Productdetail> getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(Set<Productdetail> productdetails) {
		this.productdetails = productdetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", account=" + account + ", category=" + category + ", producer="
				+ producer + ", producerName=" + producerName + ", productImage=" + productImage + ", productPrice="
				+ productPrice + ", productSale=" + productSale + ", content=" + content + ", productDescription="
				+ productDescription + ", productStatus=" + productStatus + ", createDate=" + createDate
				+ ", orderitems=" + orderitems + ", productdetails=" + productdetails + "]";
	}

	
}
