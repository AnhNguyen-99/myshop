package com.myshop.entity;

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
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name = "accountName")
	private String accountName;
	
	@Column(name = "accountPass")
	private String accountPass;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "accountMail")
	private String accountMail;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "moblie")
	private String moblie;
	
	@Column(name = "accountStatus")
	private Boolean accountStatus;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Role roleId;
	
	@OneToMany(mappedBy = "accountId")
	public Collection<Order> order;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPass() {
		return accountPass;
	}

	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAccountMail() {
		return accountMail;
	}

	public void setAccountMail(String accountMail) {
		this.accountMail = accountMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public Boolean getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Collection<Order> getOrder() {
		return order;
	}

	public void setOrder(Collection<Order> order) {
		this.order = order;
	}

}
