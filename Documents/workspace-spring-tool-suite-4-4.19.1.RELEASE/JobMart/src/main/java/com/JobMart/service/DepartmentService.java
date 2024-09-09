package com.JobMart.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.Department;
import com.JobMart.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

	public  Department getDepartmentById(UUID Id) {
		return departmentRepository.findById(Id).orElse(null);
	}

	public UUID saveDepartment(Department department) {
		department.setCrtTs(new Timestamp(System.currentTimeMillis()));
		department.setModTs(new Timestamp(System.currentTimeMillis()));
		department = departmentRepository.save(department);
		return department.getDepartmentId();
	}

	public UUID updateDepartment(Department department, UUID Id) {
		department.setModTs(new Timestamp(System.currentTimeMillis()));
		department.setDepartmentId(UUID.randomUUID());
		departmentRepository.save(department);
		return department.getDepartmentId();
	}
	
	public void deleteDepartment(UUID id) {
		departmentRepository.deleteById(id);
	}
}
