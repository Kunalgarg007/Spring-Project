package com.JobMart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.Skills;
import com.JobMart.repository.SkillsRepository;

@Service
public class SkillsService {
	
	@Autowired
	SkillsRepository skillsRepository;

	public List<Skills> getAllSkills() {
		return skillsRepository.findAll();
	}

	public Skills getSkillsById(UUID Id) {
		return skillsRepository.findById(Id).orElse(null);
	}

	public UUID saveSkills(Skills skills) {
		skills.setId(UUID.randomUUID());
		skills = skillsRepository.save(skills);
		return skills.getId();
	}

	public UUID updateSkills(Skills skills, UUID Id) {
		skillsRepository.save(skills);
		return skills.getId();
	}

	public void deleteSkills(UUID id) {
		skillsRepository.deleteById(id);
	}

}
