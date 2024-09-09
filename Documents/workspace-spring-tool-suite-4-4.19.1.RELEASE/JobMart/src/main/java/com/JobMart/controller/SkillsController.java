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

import com.JobMart.entity.Skills;
import com.JobMart.service.SkillsService;

@RestController
@RequestMapping("/skills")

public class SkillsController {

	@Autowired
	 SkillsService skillsService;
	 @GetMapping(path = "")
	 public ResponseEntity<?> getAllSkills() throws IOException{
		 return ResponseEntity.status(HttpStatus.OK).body(skillsService.getAllSkills());
	 }
	 
	 @GetMapping(path = "/{SkillId}")
	 public ResponseEntity<?> getSkillById(@PathVariable UUID SkillId){
		 return ResponseEntity.status(HttpStatus.OK).body(skillsService.getSkillsById(SkillId));
	 }
	 
	 @PostMapping(path="")
	 public ResponseEntity<?> saveSkill(@RequestBody Skills skills){
		 return ResponseEntity.status(HttpStatus.OK).body(skillsService.saveSkills(skills));
	 }
	 
	 @PutMapping(path="/{SkillId}")
	 public ResponseEntity<?> updateSkill(@PathVariable UUID SkillId,@RequestBody Skills skills){
		 return ResponseEntity.status(HttpStatus.OK).body(skillsService.updateSkills(skills, SkillId));
	 }
	 @DeleteMapping(path="/{SkillId}")
	 public void DeleteSkill(@PathVariable UUID SkillId) {
		 skillsService.deleteSkills(SkillId);
	 }
}
