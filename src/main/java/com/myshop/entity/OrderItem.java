package com.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myshop.entity.Orders;

@Entity
@Table(name = "OrderItem", catalog = "myshop")
public class OrderItem implements java.io.Serializable {

	private static final long serialVersionUID = 2960663706677393032L;
	
	private int OrderItemId;
	private Orders orders;
	private Product product;
	private int quantity;
	private double price;

	public OrderItem() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderItemId", unique = true, nullable = false)
	public int getOrderItemId() {
		return this.OrderItemId;
	}

	public void setOrderItemId(int OrderItemId) {
		this.OrderItemId = OrderItemId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId", nullable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
