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
@Table(name = "color", catalog = "myshop")
public class Color implements java.io.Serializable {

	private static final long serialVersionUID = -1799030138604370698L;

	private int colorId;
	private String colorName;
	private Date createDate;
	private Set<Productdetail> productdetails = new HashSet<Productdetail>(0);

	public Color() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "colorId", unique = true, nullable = false)
	public int getColorId() {
		return this.colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	@Column(name = "colorName", nullable = false, length = 100)
	public String getColorName() {
		return this.colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
	public Set<Productdetail> getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(Set<Productdetail> productdetails) {
		this.productdetails = productdetails;
	}

}
