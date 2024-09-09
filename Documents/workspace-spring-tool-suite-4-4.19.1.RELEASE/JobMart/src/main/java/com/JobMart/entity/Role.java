package com.JobMart.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RoleId;

	@Column(name = "role_name")
	private String RoleName;

	@Column(name = "role_description")
	private String RoleDesc;

	public UUID getRoleId() {
		return RoleId;
	}

	public void setRoleId(UUID roleId) {
		this.RoleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		this.RoleName = roleName;
	}

	public String getRoleDesc() {
		return RoleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.RoleDesc = roleDesc;
	}

}
