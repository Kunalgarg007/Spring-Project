package com.JobMart.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role_category")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RoleCategoryId;

	@Column(name = "role_category_name")
	private String RoleCategoryName;

	@Column(name="role_category_description")
	private String RoleCategoryDescription;
	
	@Column(name = "crt_by")
	private UUID CrtBy;
	
	@Column(name = "mod_by")
	private UUID ModBy;
	
	@Column(name = "crt_ts")
	private Timestamp CrtTs;
	
	@Column(name = "mod_ts")
	private Timestamp ModTs;
}
