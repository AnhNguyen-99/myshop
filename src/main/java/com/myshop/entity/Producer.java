package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "producer", catalog = "myshop_1")
public class Producer implements java.io.Serializable {

	private static final long serialVersionUID = -4090426484322743894L;

	private Integer producerId;
	private String producerName;
	private Date createDate;
	private Set<Product> products = new HashSet<Product>(0);

	public Producer() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}

	public Producer(Integer producerId) {
		this.producerId = producerId;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "producerId", unique = true, nullable = false)
	public Integer getProducerId() {
		return this.producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	@Column(name = "producerName", length = 100)
	public String getProducerName() {
		return this.producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
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
