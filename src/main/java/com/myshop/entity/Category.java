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
@Table(name = "category", catalog = "myshop")
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 425814635484903192L;

	private int categoryId;
	private Account account;
	private String categoryName;
	private Boolean categoryStatus;
	private Date createDate;
	private Set<Product> products = new HashSet<Product>(0);

	public Category() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
	}

	public Category(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId", unique = true, nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "categoryName", nullable = false, length = 100)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "categoryStatus")
	public Boolean getCategoryStatus() {
		return this.categoryStatus;
	}

	public void setCategoryStatus(Boolean categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
