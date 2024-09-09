package com.JobMart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.IndustryType;
import com.JobMart.repository.IndustryTypeRepository;

@Service
public class IndustryTypeService {

	@Autowired
	IndustryTypeRepository industryTypeRepository;

	public List<IndustryType> getAllIndustryTypes() {
		return industryTypeRepository.findAll();
	}

	public IndustryType getIndustryTypeById(UUID Id) {
		return industryTypeRepository.findById(Id).orElse(null);
	}

	public UUID saveIndustryType(IndustryType industryType) {
		industryType.setIndustryTypeId(UUID.randomUUID());
		industryType = industryTypeRepository.save(industryType);
		return industryType.getIndustryTypeId();
	}

	public UUID updateIndustryType(IndustryType industryType, UUID id) {
		industryTypeRepository.save(industryType);
		return industryType.getIndustryTypeId();
	}

	public void deleteIndustryType(UUID id) {
		industryTypeRepository.deleteById(id);
	}

}
