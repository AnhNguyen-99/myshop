package com.myshop.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer {

	@Id
	@Column(name = "producerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer producerId;
	
	@Column(name = "producerName")
	private String producerName;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@OneToMany(mappedBy = "producerId", targetEntity = Producer.class)
	public Collection<Product> product;

	public Producer() {
		Calendar c = Calendar.getInstance();
		this.createDate = c.getTime();
	}
	
	
	public Producer(Integer producerId) {
		this.producerId = producerId;
	}


	public Integer getProducerId() {
		return producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Collection<Product> getProduct() {
		return product;
	}

	public void setProduct(Collection<Product> product) {
		this.product = product;
	}
	
}
