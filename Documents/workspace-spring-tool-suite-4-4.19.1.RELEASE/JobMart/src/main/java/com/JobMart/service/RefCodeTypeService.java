package com.JobMart.service;

import java.sql.Timestamp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.RefCodeTypes;
import com.JobMart.repository.RefCodeTypeRepository;

@Service
public class RefCodeTypeService {

	@Autowired
	 RefCodeTypeRepository refCodeTypeRepository;
	
	public List<RefCodeTypes> getAllRefCodeTypes() {
		return refCodeTypeRepository.findAll();
	}

	public RefCodeTypes getRefCodeTypeById(UUID Id) {
		return refCodeTypeRepository.findById(Id).orElse(null);
	}

	public UUID saveRefCodeTypes(RefCodeTypes refCodeTypes) {
		refCodeTypes.setCrtTs(new Timestamp(System.currentTimeMillis()));
		refCodeTypes.setModTs(new Timestamp(System.currentTimeMillis()));
		refCodeTypes.setRefcodeTypeId(UUID.randomUUID());
		refCodeTypes = refCodeTypeRepository.save(refCodeTypes);
		return refCodeTypes.getRefcodeTypeId();
	}

	public UUID updateRefCodeTypes(RefCodeTypes refCodeTypes,UUID Id) {
		 refCodeTypes.setModTs(new Timestamp(System.currentTimeMillis()));
		refCodeTypeRepository.save( refCodeTypes);
		return  refCodeTypes.getRefcodeTypeId();
	}

	public void deleteRefCodeTypes(UUID RefcodeTypeId) {
		refCodeTypeRepository.deleteById(RefcodeTypeId);
	}
}
