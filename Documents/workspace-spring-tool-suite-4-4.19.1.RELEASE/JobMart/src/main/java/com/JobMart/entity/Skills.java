package com.JobMart.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private UUID id;
	

	@Column(name="skill_nm")
	private String SkillName;
	
	@Column(name="skill_desc")
	private String SkillDesc;
	
	

	public Skills() {
		
	}

	public Skills(UUID id, String skillName, String skillDesc){
		super();
		this.id = id;
		SkillName = skillName;
		SkillDesc = skillDesc;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String skillName) {
		SkillName = skillName;
	}

	public String getSkillDesc() {
		return SkillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		SkillDesc = skillDesc;
	}
}
