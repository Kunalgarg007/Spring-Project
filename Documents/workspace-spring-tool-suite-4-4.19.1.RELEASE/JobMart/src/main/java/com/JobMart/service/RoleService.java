package com.JobMart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.Role;
import com.JobMart.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Role getRoleById(UUID id) {
		return roleRepository.findById(id).orElse(null);
	}

	public UUID saveRole(Role role) {
		role.setRoleId(UUID.randomUUID());
		role = roleRepository.save(role);
		return role.getRoleId();
	}

	public UUID updateRole(UUID id, Role role) {
		roleRepository.save(role);
		return role.getRoleId();
	}

	public void deleteRole(UUID id) {
		roleRepository.deleteById(id);
	}
}
