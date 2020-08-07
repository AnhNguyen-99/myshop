package com.myshop.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sizes", catalog = "myshop")
public class Sizes implements java.io.Serializable {

	private static final long serialVersionUID = 7386638915250409846L;
	
	private int sizeId;
	private String sizeName;
	private Date createDate;
	private Set<Productdetail> productdetails = new HashSet<Productdetail>(0);

	public Sizes() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sizeId", unique = true, nullable = false)
	public int getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	@Column(name = "sizeName", nullable = false, length = 100)
	public String getSizeName() {
		return this.sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sizes")
	public Set<Productdetail> getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(Set<Productdetail> productdetails) {
		this.productdetails = productdetails;
	}

}
