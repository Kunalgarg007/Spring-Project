package com.JobMart.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="refcode_types")
public class RefCodeTypes {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RefcodeTypeId;
	
	@Column(name="ref_code_type")
	private String RefCodeType;
	@NotBlank(message = "value must be boolean")
	@Column(name="is_display_editable")
	private Boolean IsDisplayEditable;
	@NotBlank(message = "value must be boolean")
	@Column(name="is_crud_enabled")
	private Boolean IsCrudEditable;
	
	@Column(name="crt_by")
	private UUID crtBy;
	
	@Column(name="crt_ts")
	private Timestamp crtTs;
	
	@Column(name="mod_by")
	private UUID modBy;
	
	@Column(name="mod_ts")
	private Timestamp modTs;


	public UUID getRefcodeTypeId() {
		return RefcodeTypeId;
	}


	public void setRefcodeTypeId(UUID refcodeTypeId) {
		RefcodeTypeId = refcodeTypeId;
	}


	public String getRefCodeType() {
		return RefCodeType;
	}


	public void setRefCodeType(String refCodeType) {
		RefCodeType = refCodeType;
	}


	public Boolean getIsDisplayEditable() {
		return IsDisplayEditable;
	}


	public void setIsDisplayEditable(Boolean isDisplayEditable) {
		IsDisplayEditable = isDisplayEditable;
	}


	public Boolean getIsCrudEditable() {
		return IsCrudEditable;
	}


	public void setIsCrudEditable(Boolean isCrudEditable) {
		IsCrudEditable = isCrudEditable;
	}


	public UUID getCrtBy() {
		return crtBy;
	}


	public void setCrtBy(UUID crtBy) {
		this.crtBy = crtBy;
	}


	public Timestamp getCrtTs() {
		return crtTs;
	}


	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;
	}


	public UUID getModBy() {
		return modBy;
	}


	public void setModBy(UUID modBy) {
		this.modBy = modBy;
	}


	public Timestamp getModTs() {
		return modTs;
	}


	public void setModTs(Timestamp modTs) {
		this.modTs = modTs;
	}


	public RefCodeTypes(UUID refcodeTypeId, String refCodeType,
		 Boolean isDisplayEditable,
			 Boolean isCrudEditable, UUID crtBy, Timestamp crtTs,
			UUID modBy, Timestamp modTs) {
		super();
		RefcodeTypeId = refcodeTypeId;
		RefCodeType = refCodeType;
		IsDisplayEditable = isDisplayEditable;
		IsCrudEditable = isCrudEditable;
		this.crtBy = crtBy;
		this.crtTs = crtTs;
		this.modBy = modBy;
		this.modTs = modTs;
	}


	public RefCodeTypes() {
		// TODO Auto-generated constructor stub
	}
	
	
}
