package com.JobMart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.JobType;
import com.JobMart.repository.JobTypeRepository;

@Service
public class JobTypeService {

	@Autowired
	JobTypeRepository jobTypeRepository;

	public List<JobType> getAllJobType() {
		return jobTypeRepository.findAll();
	}

	public JobType getJobTypeById(UUID id) {
		return jobTypeRepository.findById(id).orElse(null);
	}

	public UUID saveJobType(JobType jobType) {
		jobType.setJobTypedId(UUID.randomUUID());
		jobType = jobTypeRepository.save(jobType);
		return jobType.getJobTypedId();
	}

	public UUID updateJobType(UUID id, JobType jobType) {
		jobTypeRepository.save(jobType);
		return jobType.getJobTypedId();
	}

	public void deleteJobType(UUID id) {
		jobTypeRepository.deleteById(id);
	}

}
