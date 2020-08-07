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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "news", catalog = "myshop")
public class News implements java.io.Serializable {

	private static final long serialVersionUID = 7855494647692085860L;

	private int newsId;
	private Account account;
	private String title;
	private String content;
	private String image;
	private Boolean newsStatus;
	private Date createDate;

	public News() {
		Calendar calendar = Calendar.getInstance();
		this.createDate = calendar.getTime();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "newsId", unique = true, nullable = false)
	public int getNewsId() {
		return this.newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "image", nullable = false, length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "newsStatus")
	public Boolean getNewsStatus() {
		return this.newsStatus;
	}

	public void setNewsStatus(Boolean newsStatus) {
		this.newsStatus = newsStatus;
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
