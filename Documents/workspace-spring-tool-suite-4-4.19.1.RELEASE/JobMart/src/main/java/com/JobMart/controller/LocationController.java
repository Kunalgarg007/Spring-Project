package com.JobMart.controller;



import com.JobMart.entity.Location;
import com.JobMart.service.LocationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
public class LocationController {

	 @Autowired
	    LocationService locationService;
	    
	    @GetMapping(path = "")
	    public ResponseEntity<?> getAllLocation() 
						throws IOException {
	        return ResponseEntity.status(HttpStatus.OK).body(locationService.getAllLocation());
	    }
	    
	    @GetMapping(path = "/{locationId}")
	    public ResponseEntity<?> getLocationById(@PathVariable UUID LocationId) {
	        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationById(LocationId));
	    }

	    @PostMapping(path = "")
	    public ResponseEntity<?> saveLocation(@RequestBody Location location) {
	        return ResponseEntity.status(HttpStatus.OK).body(locationService.saveLocation(location));
	    }
	    
	    @PutMapping(path = "/{LocationId}")
	    public ResponseEntity<?> updateLocation(@PathVariable UUID LocationId,@RequestBody Location location) {
	        return ResponseEntity.status(HttpStatus.OK).body(locationService.updateLocation(location,LocationId));
	    }
	    
	    @DeleteMapping(path = "/{LocationId}")
	    public void deleteLocation(@PathVariable UUID LocationId) {
	    	locationService.deleteLocation(LocationId);
	    }
	    
}
