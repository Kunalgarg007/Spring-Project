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
@Table(name = "job_Type")
@NoArgsConstructor
@AllArgsConstructor
public class JobType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private UUID JobTypeId;

	@Column(name = "job_type_name")
	private String JobTypeName;

	@Column(name = "job_type_description")
	private String JobTypeDesc;

	public UUID getJobTypedId() {
		return JobTypeId;
	}

	public void setJobTypedId(UUID jobTypeId) {
		JobTypeId = jobTypeId;
	}

	public String getJobTypeName() {
		return JobTypeName;
	}

	public void setJobTypeName(String jobTypeName) {
		JobTypeName = jobTypeName;
	}

	public String getJobTypeDesc() {
		return JobTypeDesc;
	}

	public void setJobTypeDesc(String jobTypeDesc) {
		JobTypeDesc = jobTypeDesc;
	}

}
