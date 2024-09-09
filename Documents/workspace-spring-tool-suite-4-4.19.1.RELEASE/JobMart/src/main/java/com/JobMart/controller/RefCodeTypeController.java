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

import com.JobMart.entity.RefCodeTypes;
import com.JobMart.service.RefCodeTypeService;
@RestController
@RequestMapping("/refcodetypes")
public class RefCodeTypeController {
	 @Autowired
	    RefCodeTypeService refCodeTypeService;
	    
	    @GetMapping(path = "")
	    public ResponseEntity<?> getAllRefCodeTypes() 
						throws IOException {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodeTypeService.getAllRefCodeTypes());
	    }
	    
	    @GetMapping(path = "/{refCodeTypeId}")
	    public ResponseEntity<?> getRefCodeTypeById(@PathVariable UUID RefcodeTypeId) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodeTypeService.getRefCodeTypeById(RefcodeTypeId));
	    }

	    @PostMapping(path = "")
	    public ResponseEntity<?> saveRefCodeTypes(@RequestBody RefCodeTypes refCodeTypes) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodeTypeService.saveRefCodeTypes(refCodeTypes));
	    }
	    
	    @PutMapping(path = "/{refCodeTypeId}")
	    public ResponseEntity<?> updateRefCodeTypes(@PathVariable UUID RefcodeTypeId,@RequestBody RefCodeTypes refCodeTypes) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodeTypeService.updateRefCodeTypes(refCodeTypes,RefcodeTypeId));
	    }
	    
	    @DeleteMapping(path = "/{refCodeTypeId}")
	    public void deleteRefCodeTypes(@PathVariable UUID RefcodeTypeId ) {
	    	refCodeTypeService.deleteRefCodeTypes(RefcodeTypeId);
	    }
}
