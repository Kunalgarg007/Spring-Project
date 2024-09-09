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

import com.JobMart.entity.RefCodes;
import com.JobMart.service.RefCodesService;

@RestController
@RequestMapping("/refcodes")
public class RefCodesController {
	 @Autowired
	    RefCodesService refCodesService;
	    
	    @GetMapping(path = "")
	    public ResponseEntity<?> getAllRefCodes() 
						throws IOException {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodesService.getAllRefCodes());
	    }
	    
	    @GetMapping(path = "/{RefCodeId}") // Change path variable name to "RefCodeId"
	    public ResponseEntity<?> getrefCodesById(@PathVariable UUID RefCodeId) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodesService.getRefCodesById(RefCodeId));
	    }


	    @PostMapping(path = "rfcodes")
	    public ResponseEntity<?> saveRefCodes(@RequestBody RefCodes refcodes) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodesService.saveRefCodes(refcodes));
	    }
	    
	    @PutMapping(path = "/{refCodesId}")
	    public ResponseEntity<?> updateRefCodes(@PathVariable UUID refCodesId,@RequestBody RefCodes refcodes) {
	        return ResponseEntity.status(HttpStatus.OK).body(refCodesService.updateRefCodes(refcodes,refCodesId));
	    }
	    @DeleteMapping(path = "/{RefCodeId}") // Change path variable name to "RefCodeId"
	    public void deleteRefCodes(@PathVariable UUID RefCodeId) {
	        refCodesService.deleteRefCodes(RefCodeId);
	    }

	    
}
