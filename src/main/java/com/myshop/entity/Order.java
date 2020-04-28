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
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name = "orderName")
	private String orderName;

	@Column(name = "mail")
	private String mail;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	@Column(name = "totalPrice")
	private float totalPrice;

	@Column(name = "orderStatus")
	private Boolean orderStatus;

	@Column(name = "orderDate")
	private Date orderDate;

	@Column(name = "createDate")
	private Date createDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId")
	private Account accountId;

	@OneToMany(mappedBy = "orderId")
	public Collection<OrderItem> orderItem;

	public Order() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public Collection<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Collection<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

}
