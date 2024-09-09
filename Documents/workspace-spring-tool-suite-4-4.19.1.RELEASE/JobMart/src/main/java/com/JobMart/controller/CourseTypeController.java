package com.JobMart.controller;

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

import com.JobMart.entity.CourseType;
import com.JobMart.service.CourseTypeService;

@RestController
@RequestMapping("/courseType")
public class CourseTypeController {

	@Autowired
	CourseTypeService courseTypeService;

	@GetMapping
	public ResponseEntity<?> getAllCourseTypes() {
		return ResponseEntity.status(HttpStatus.OK).body(courseTypeService.getAllCourseTypes());

	}

	@GetMapping(path = "/{courseTypeId}")
	public ResponseEntity<?> getCourseTypeById(@PathVariable UUID courseTypeId) {
		return ResponseEntity.status(HttpStatus.OK).body(courseTypeService.getCourseTypeById(courseTypeId));
	}

	@PostMapping(path = "")
	public ResponseEntity<?> saveCourseType(@RequestBody CourseType courseType) {
		return ResponseEntity.status(HttpStatus.OK).body(courseTypeService.saveCourseType(courseType));
	}

	@PutMapping(path = "/{courseTypeId}")
	public ResponseEntity<?> update(@PathVariable UUID courseTypeId, @RequestBody CourseType courseType) {
		return ResponseEntity.status(HttpStatus.OK).body(courseTypeService.updateCourseType(courseType, courseTypeId));
	}

	@DeleteMapping(path = "/{courseTypeId}")
	public void deleteCourseType(@PathVariable UUID courseTypeId) {
		courseTypeService.deleteCourseType(courseTypeId);
	}
}
