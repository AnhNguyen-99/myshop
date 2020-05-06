package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orderitem", catalog = "myshop_1")
public class OrderItem implements java.io.Serializable {

	private static final long serialVersionUID = -4187741387229353122L;
	
	private Integer orderItemId;
	private Order order;
	private Product product;
	private Integer orderItemQuantity;
	private Float orderItemPrice;
	private Boolean orderItemStatus;
	private Date createDate;

	public OrderItem() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "orderItemId", unique = true, nullable = false)
	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	public Order getOrders() {
		return this.order;
	}

	public void setOrders(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "orderItemQuantity")
	public Integer getOrderItemQuantity() {
		return this.orderItemQuantity;
	}

	public void setOrderItemQuantity(Integer orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	@Column(name = "orderItemPrice", precision = 12, scale = 0)
	public Float getOrderItemPrice() {
		return this.orderItemPrice;
	}

	public void setOrderItemPrice(Float orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	@Column(name = "orderItemStatus")
	public Boolean getOrderItemStatus() {
		return this.orderItemStatus;
	}

	public void setOrderItemStatus(Boolean orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
