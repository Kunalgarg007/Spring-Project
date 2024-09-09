package com.JobMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobMart.entity.CourseType;

import java.util.UUID;
@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, UUID> {
}
