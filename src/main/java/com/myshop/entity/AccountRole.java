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


@Entity
@Table(name = "account_role", catalog = "myshop")
public class AccountRole implements java.io.Serializable {

	private static final long serialVersionUID = -5963818418810146717L;
	private int accountRoleId;
	private Account account;
	private Role role;

	public AccountRole() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_role_id", unique = true, nullable = false)
	public int getAccountRoleId() {
		return this.accountRoleId;
	}

	public void setAccountRoleId(int accountRoleId) {
		this.accountRoleId = accountRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
