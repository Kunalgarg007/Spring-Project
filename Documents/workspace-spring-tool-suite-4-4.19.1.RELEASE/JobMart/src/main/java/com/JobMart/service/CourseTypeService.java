package com.JobMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.CourseType;
import com.JobMart.repository.CourseTypeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CourseTypeService {

    @Autowired
    CourseTypeRepository courseTypeRepository;

    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    public CourseType getCourseTypeById(UUID Id) {
    	return courseTypeRepository.findById(Id).orElse(null);
    }


	public UUID saveCourseType(CourseType courseType) {
		courseType.setCourseTypeId(UUID.randomUUID());
		courseType = courseTypeRepository.save(courseType);
		return courseType.getCourseTypeId();
	}

	public UUID updateCourseType(CourseType courseType,UUID id) {
		courseTypeRepository.save(courseType);
		return courseType.getCourseTypeId();
	}

	public void deleteCourseType(UUID id) {
		courseTypeRepository.deleteById(id);
	}

   
}
