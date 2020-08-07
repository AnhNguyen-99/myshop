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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account", catalog = "myshop")
public class Account implements java.io.Serializable {
	
	private static final long serialVersionUID = -4328995011502431496L;

	private int accountId;
	private String accountName;
	private String accountPass;
	private String fullName;
	private String address;
	private String mail;
	private String mobile;
	private Boolean accountStatus;
	private Date createDate;
	private Set<AccountRole> accountRoles = new HashSet<AccountRole>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Producer> producers = new HashSet<Producer>(0);
	private Set<News> newses = new HashSet<News>(0);
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	public Account() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
	}

	public Account(int accountId) {
		this.accountId = accountId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId", unique = true, nullable = false)
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name = "accountName", nullable = false, length = 100)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "accountPass", nullable = false, length = 100)
	public String getAccountPass() {
		return this.accountPass;
	}

	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}

	@Column(name = "fullName", nullable = false)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "mail", nullable = false, length = 100)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "mobile", nullable = false, length = 10)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "accountStatus")
	public Boolean getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(Boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<AccountRole> getAccountRoles() {
		return this.accountRoles;
	}

	public void setAccountRoles(Set<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Producer> getProducers() {
		return this.producers;
	}

	public void setProducers(Set<Producer> producers) {
		this.producers = producers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<News> getNewses() {
		return this.newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
