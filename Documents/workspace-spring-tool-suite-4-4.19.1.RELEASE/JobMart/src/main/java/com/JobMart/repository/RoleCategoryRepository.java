package com.JobMart.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobMart.entity.RoleCategory;

@Repository
public interface RoleCategoryRepository extends JpaRepository<RoleCategory, UUID>{

}
