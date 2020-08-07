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
@Table(name = "producer", catalog = "myshop")
public class Producer implements java.io.Serializable {

	private static final long serialVersionUID = 7487617247133767680L;
	
	private int producerId;
	private Account account;
	private String producerName;
	private Boolean producerStatus;
	private Date createDate;
	private Set<Product> products = new HashSet<Product>(0);

	public Producer() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
	}

	public Producer(int producerId) {
		this.producerId = producerId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producerId", unique = true, nullable = false)
	public int getProducerId() {
		return this.producerId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "producerName", nullable = false, length = 100)
	public String getProducerName() {
		return this.producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	@Column(name = "producerStatus")
	public Boolean getProducerStatus() {
		return this.producerStatus;
	}

	public void setProducerStatus(Boolean producerStatus) {
		this.producerStatus = producerStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producer")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
