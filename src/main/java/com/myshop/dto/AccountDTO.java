package com.myshop.dto;

import java.util.Date;

public class AccountDTO {

	private int accountId;
	private String accountName;
	private String accountPass;
	private String fullName;
	private String address;
	private String mail;
	private String mobile;
	private Boolean accountStatus;
	private Date createDate;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
}
