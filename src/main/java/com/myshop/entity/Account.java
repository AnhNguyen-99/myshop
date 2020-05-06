package com.myshop.entity;

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
@Table(name = "account", catalog = "myshop_1")
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 1680396039133534680L;
	
	private Integer accountId;
	private Role role;
	private String accountName;
	private String accountPass;
	private String fullName;
	private String accountMail;
	private String address;
	private String moblie;
	private Boolean accountStatus;
	private Date createDate;
	private Set<Order> orderses = new HashSet<Order>(0);

	public Account() {
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "accountId", unique = true, nullable = false)
	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	@Column(name = "accountMail", length = 100)
	public String getAccountMail() {
		return this.accountMail;
	}

	public void setAccountMail(String accountMail) {
		this.accountMail = accountMail;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "moblie", length = 20)
	public String getMoblie() {
		return this.moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
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
	public Set<Order> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Order> orderses) {
		this.orderses = orderses;
	}

}
