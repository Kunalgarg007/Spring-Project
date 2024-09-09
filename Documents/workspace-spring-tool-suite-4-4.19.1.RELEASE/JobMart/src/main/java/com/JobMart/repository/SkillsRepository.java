package com.JobMart.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobMart.entity.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, UUID>{
	
}