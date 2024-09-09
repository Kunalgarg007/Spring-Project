package com.JobMart.service;

import com.JobMart.entity.Location;
import com.JobMart.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import java.util.UUID;

@Service
public class LocationService {

    @Autowired
	 LocationRepository locationRepository;

	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}

	public Location getLocationById(UUID Id) {
		return locationRepository.findById(Id).orElse(null);
	}

	public UUID saveLocation(Location location) {
		location.setCrtTs(new Timestamp(System.currentTimeMillis()));
		location.setModTs(new Timestamp(System.currentTimeMillis()));
		location = locationRepository.save(location);
		return location.getLocationId();
	}

	public UUID updateLocation(Location location,UUID Id) {
		location.setModTs(new Timestamp(System.currentTimeMillis()));
		location.setLocationId(UUID.randomUUID());
		location.setCrtTs(new Timestamp(System.currentTimeMillis()));
		location.setLocationId(UUID.randomUUID());
		locationRepository.save(location);
		return location.getLocationId();
	}

	public void deleteLocation(UUID Id) {
		locationRepository.deleteById(Id);
	}
}
