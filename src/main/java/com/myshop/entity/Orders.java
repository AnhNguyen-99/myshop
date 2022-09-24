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
@Table(name = "orders", catalog = "myshop")
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = -304479304493032400L;
	
	private int orderId;
	private Account account;
	private Statusorder statusorder;
	private String orderName;
	private String mail;
	private String address;
	private String phone;
	private double totalPrice;
	private Date orderDate;
	private Date receiveDate;
	private Set<OrderItem> OrderItems = new HashSet<OrderItem>(0);

	public Orders() {
		Calendar calendar = Calendar.getInstance();
		this.orderDate = calendar.getTime();
	}

	public Orders(int orderId) {
		this.orderId = orderId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId", unique = true, nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	@JoinColumn(name = "orderStatus", nullable = false)
	public Statusorder getStatusorder() {
		return this.statusorder;
	}

	public void setStatusorder(Statusorder statusorder) {
		this.statusorder = statusorder;
	}

	@Column(name = "orderName", nullable = false, length = 100)
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column(name = "mail", nullable = false, length = 100)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", nullable = false, length = 10)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "totalPrice", nullable = false, precision = 22, scale = 0)
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "orderDate", length = 26)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receiveDate", length = 26)
	public Date getReceiveDate() {
		return this.receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<OrderItem> getOrderItems() {
		return this.OrderItems;
	}

	public void setOrderItems(Set<OrderItem> OrderItems) {
		this.OrderItems = OrderItems;
	}

}
