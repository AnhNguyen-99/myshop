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
@Table(name = "role", catalog = "myshop")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = -6185533053115667720L;
	
	private int roleId;
	private String roleName;
	private Date createDate;
	private Set<AccountRole> accountRoles = new HashSet<AccountRole>(0);

	public Role() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId", unique = true, nullable = false)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "roleName", nullable = false, length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 26)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<AccountRole> getAccountRoles() {
		return this.accountRoles;
	}

	public void setAccountRoles(Set<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

}
