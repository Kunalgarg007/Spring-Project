package com.JobMart.entity;

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
@Table(name = "industry_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndustryType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private UUID IndustryTypeId;

	@Column(name = "industry_name")
	private String IndustryName;

	@Column(name = "industry_sector")
	private String IndustrySector;

	@Column(name = "industry_description")
	private String IndustryDescription;

}
