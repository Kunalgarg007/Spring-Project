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
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID DepartmentId;

	@Column(name = "department_name")
	private String DepartmentName;

	@Column(name = "crt_by")
	private UUID CrtBy;

	@Column(name = "mod_by")
	private UUID ModBy;

	@Column(name = "crt_ts")
	private Timestamp CrtTs;

	@Column(name = "mod_ts")
	private Timestamp ModTs;
	
	@Column(name="is_active")
	private Boolean IsActive;

}
