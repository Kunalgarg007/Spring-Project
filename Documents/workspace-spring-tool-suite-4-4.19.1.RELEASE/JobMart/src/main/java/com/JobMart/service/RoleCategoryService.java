package com.JobMart.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.RoleCategory;
import com.JobMart.repository.RoleCategoryRepository;

@Service
public class RoleCategoryService {

	@Autowired
	RoleCategoryRepository roleCategoryRepository;

	public List<RoleCategory> getAllRoleCategory() {
		return roleCategoryRepository.findAll();
	}

	public RoleCategory getRoleCategoryById(UUID Id) {
		return roleCategoryRepository.findById(Id).orElse(null);
	}

	public UUID saveRoleCategory(RoleCategory roleCategory) {
		roleCategory.setCrtTs(new Timestamp(System.currentTimeMillis()));
		roleCategory.setModTs(new Timestamp(System.currentTimeMillis()));
		roleCategory = roleCategoryRepository.save(roleCategory);
		return roleCategory.getRoleCategoryId();
	}

	public UUID updateRoleCategory(RoleCategory roleCategory, UUID Id) {
		roleCategory.setModTs(new Timestamp(System.currentTimeMillis()));
		roleCategory.setRoleCategoryId(UUID.randomUUID());
		roleCategoryRepository.save(roleCategory);
		return roleCategory.getRoleCategoryId();
	}

	public void deleteRoleCategory(UUID Id) {
		roleCategoryRepository.deleteById(Id);
	}
}
