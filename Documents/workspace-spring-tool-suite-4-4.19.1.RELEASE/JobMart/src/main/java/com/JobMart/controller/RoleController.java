package com.JobMart.controller;

import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JobMart.entity.Role;
import com.JobMart.service.RoleService;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:9000")
public class RoleController {

	@Autowired
	RoleService roleService;

	
	@GetMapping(path="")
	public ResponseEntity<?> getAllRoles()throws IOException{
		return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRoles());
	}
	
	@GetMapping(path="/{RoleId}")
	public ResponseEntity<?> getRoleById(@PathVariable UUID RoleId){
		return ResponseEntity.status(HttpStatus.OK).body(roleService.getRoleById(RoleId));
	}
	
	@PostMapping(path="")
	public ResponseEntity<?> saveRole(@RequestBody Role role){
		return ResponseEntity.status(HttpStatus.OK).body(roleService.saveRole(role));
	}

	@PutMapping(path = "/{RoleId}")
	public ResponseEntity<?> updateRole(@PathVariable UUID RoleId,@RequestBody Role role){
		return ResponseEntity.status(HttpStatus.OK).body(roleService.updateRole(RoleId, role));
	}
	@DeleteMapping(path="/{RoleId}")
	public void DeleteRole(@PathVariable UUID RoleID){
		roleService.deleteRole(RoleID);
	}
}
