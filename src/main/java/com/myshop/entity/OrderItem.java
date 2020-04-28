package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;

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
@Table(name = "orderItem")
public class OrderItem {

	@Id
	@Column(name = "orderItemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@Column(name = "orderItemQuantity")
	private int orderItemQuantity;
	
	@Column(name = "orderItemPrice")
	private Double orderItemPrice;
	
	@Column(name = "orderItemStatus")
	private Boolean orderItemStatus;
		
	@Column(name = "createDate")
	private Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private Order orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product productId;

	public OrderItem() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}
	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public Double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(Double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public Boolean getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(Boolean orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemQuantity=" + orderItemQuantity
				+ ", orderItemPrice=" + orderItemPrice + ", orderItemStatus=" + orderItemStatus + ", createDate="
				+ createDate + ", orderId=" + orderId + ", productId=" + productId + "]";
	}
	
	
}
