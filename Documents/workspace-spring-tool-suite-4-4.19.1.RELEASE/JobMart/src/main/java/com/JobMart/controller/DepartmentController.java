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

import com.JobMart.entity.Department;
import com.JobMart.service.DepartmentService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping(path = "")
	public ResponseEntity<?> getAllDepartment() throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartment());
	}

	@GetMapping(path = "/{DepartmentId}")
	public ResponseEntity<?> getDepartmentbyId(@PathVariable UUID DepartmentId) {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentById(DepartmentId));
	}

	@PostMapping(path = "")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.saveDepartment(department));
	}

	@PutMapping(path = "/{DepartmentId}")
	public ResponseEntity<?> updateDepartment(@PathVariable UUID DepartmentId, @RequestBody Department department) {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartment(department, DepartmentId));
	}

	@DeleteMapping(path = "/{DepartmentId}")
	public void deleteDepartment(@PathVariable UUID DepartmentId) {
		departmentService.deleteDepartment(DepartmentId);
	}
}
