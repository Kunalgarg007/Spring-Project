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
import com.JobMart.entity.RoleCategory;
import com.JobMart.service.RoleCategoryService;

@RestController
@RequestMapping(path = "/roleCategory")
public class RoleCategoryController {

	@Autowired
	RoleCategoryService roleCategoryService;

	@GetMapping(path = "")
	public ResponseEntity<?> getAllRoleCategory() throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(roleCategoryService.getAllRoleCategory());
	}

	@GetMapping(path = "/{RoleCategoryId}")
	public ResponseEntity<?> getroleCategorybyId(@PathVariable UUID RoleCategoryId) {
		return ResponseEntity.status(HttpStatus.OK).body(roleCategoryService.getRoleCategoryById(RoleCategoryId));
	}

	@PostMapping(path = "")
	public ResponseEntity<?> saveRoleCategory(@RequestBody RoleCategory roleCategory) {
		return ResponseEntity.status(HttpStatus.OK).body(roleCategoryService.saveRoleCategory(roleCategory));
	}

	@PutMapping(path = "/{RoleCategoryId}")
	public ResponseEntity<?> updateRoleCategory(@PathVariable UUID RoleCategoryId,
			@RequestBody RoleCategory roleCategory) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(roleCategoryService.updateRoleCategory(roleCategory, RoleCategoryId));
	}

	@DeleteMapping(path = "/{RoleCategoryId}")
	public void deleteRole(@PathVariable UUID RoleCategoryId) {
		roleCategoryService.deleteRoleCategory(RoleCategoryId);
	}
}
