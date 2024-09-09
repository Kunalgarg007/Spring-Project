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

import com.JobMart.entity.JobType;
import com.JobMart.service.JobTypeService;

@RestController
@RequestMapping(path="/jobType")
public class JobTypeController {

	@Autowired
	JobTypeService jobTypeService;
	
	@GetMapping(path="")
	public ResponseEntity<?> getAllJobType() throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.getAllJobType());
	}

	@GetMapping(path = "/{JobTypeId}")
	public ResponseEntity<?> getJobTypeById(@PathVariable UUID JobTypeId) {
		return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.getJobTypeById(JobTypeId));
	}

	@PostMapping(path = "")
	public ResponseEntity<?> saveJobType(@RequestBody JobType jobType) {
		return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.saveJobType(jobType));
	}

	@PutMapping(path = "/{JobTypeId}")
	public ResponseEntity<?> updateJobType(@PathVariable UUID JobTypeId, @RequestBody JobType jobType) {
		return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.updateJobType(JobTypeId, jobType));
	}

	@DeleteMapping(path = "/{JobTypeId}")
	public void deleteJobType(@PathVariable UUID JobTypeId) {
		jobTypeService.deleteJobType(JobTypeId);
	}
}
