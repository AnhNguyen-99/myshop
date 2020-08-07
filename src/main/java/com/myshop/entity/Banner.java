package com.myshop.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "banner", catalog = "myshop")
public class Banner implements java.io.Serializable {

	private static final long serialVersionUID = 3401672095110386734L;

	private int bannerId;
	private String image;
	private Boolean bannerStatus;
	private Date createDate;

	public Banner() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bannerId", unique = true, nullable = false)
	public int getBannerId() {
		return this.bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	@Column(name = "image", nullable = false, length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "bannerStatus")
	public Boolean getBannerStatus() {
		return this.bannerStatus;
	}

	public void setBannerStatus(Boolean bannerStatus) {
		this.bannerStatus = bannerStatus;
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
