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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ref_codes")
public class RefCodes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RefCodeId;

	@Column(name = "ref_code_type_id")
	private UUID CodeTypeId;

	@Column(name = "ref_code_store_val")
	private int StoreVal;
     @NotBlank
	@Column(name = "ref_code_displaying_val")
	private String DisplayingValue;
     @NotBlank
     @Size(min=20,max=50)
	@Column(name = "ref_code_description")
	private String Description;

	@Column(name = "crt_by")
	private UUID crtBy;

	@Column(name = "mod_by")
	private UUID modBy;

	@Column(name = "crt_ts")
	private Timestamp crtTs;

	@Column(name = "mod_Ts")
	private Timestamp modTs;

	public UUID getRefCodeId() {
		return RefCodeId;
	}

	public void setRefCodeId(UUID refCodeId) {
		RefCodeId = refCodeId;
	}

	public UUID getCodeTypeId() {
		return CodeTypeId;
	}

	public void setCodeTypeId(UUID codeTypeId) {
		CodeTypeId = codeTypeId;
	}

	public int getStoreVal() {
		return StoreVal;
	}

	public void setStoreVal(int storeVal) {
		StoreVal = storeVal;
	}

	public String getDisplayingValue() {
		return DisplayingValue;
	}

	public void setDisplayingValue(String displayingValue) {
		DisplayingValue = displayingValue;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public UUID getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(UUID crtBy) {
		this.crtBy = crtBy;
	}

	public UUID getModBy() {
		return modBy;
	}

	public void setModBy(UUID modBy) {
		this.modBy = modBy;
	}

	public Timestamp getCrtTs() {
		return crtTs;
	}

	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;
	}

	public Timestamp getModTs() {
		return modTs;
	}

	public void setModTs(Timestamp modTs) {
		this.modTs = modTs;
	}

	public RefCodes() {

	}
}
