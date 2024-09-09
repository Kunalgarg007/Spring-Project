package com.JobMart.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JobMart.entity.IndustryType;
import com.JobMart.service.IndustryTypeService;

@RestController
@RequestMapping("/industryType")
public class IndustryTypeController {

	@Autowired
	IndustryTypeService industryTypeService;
    @GetMapping(path="")
	public ResponseEntity<?> getAllIndustryType() throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(industryTypeService.getAllIndustryTypes());
	}

	@GetMapping(path = "/{IndustryTypeId}")
	public ResponseEntity<?> getIndustryTypeById(@PathVariable UUID IndustryTypeId) {
		return ResponseEntity.status(HttpStatus.OK).body(industryTypeService.getIndustryTypeById(IndustryTypeId));
	}

	@PostMapping(path = "")
	public ResponseEntity<?> saveIndustryType(@RequestBody IndustryType industryType) {
		return ResponseEntity.status(HttpStatus.OK).body(industryTypeService.saveIndustryType(industryType));
	}

	@PutMapping(path = "/{IndustryTypeId}")
	public ResponseEntity<?> updateIndustryType(@PathVariable UUID IndustryTypeId,
			@RequestBody IndustryType industryType) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(industryTypeService.updateIndustryType(industryType, IndustryTypeId));
	}

	@DeleteMapping(path = "/{IndustryTypeId}")
	public void deleteIndustryType(@PathVariable UUID IndustryTypeId) {
		industryTypeService.deleteIndustryType(IndustryTypeId);
	}
}
