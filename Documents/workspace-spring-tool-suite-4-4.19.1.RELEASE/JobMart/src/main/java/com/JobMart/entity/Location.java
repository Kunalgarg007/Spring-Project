package com.JobMart.entity;

import java.io.Serializable;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="location")

public class Location implements Serializable{
	private static final long serialVersionUID = 1L;	


@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
    @Column(name="location_id")
	private UUID LocationId;
@NotBlank
@Size(min = 4, max = 10)
    @Column(name="city_nm")
    private String cityName;
    @Column(name="crt_by")
    private UUID CrtBy; 
    @Column(name="mod_by")
private UUID ModBy;
@Column(name="crt_ts")
private Timestamp CrtTs;
@Column(name="mod_ts")
private Timestamp ModTs;
}
