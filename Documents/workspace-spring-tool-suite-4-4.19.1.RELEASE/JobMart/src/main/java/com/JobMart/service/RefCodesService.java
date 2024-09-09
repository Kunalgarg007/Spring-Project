package com.JobMart.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobMart.entity.RefCodes;
import com.JobMart.repository.RefCodesRepositoy;

@Service
public class RefCodesService {
	   @Autowired
		private RefCodesRepositoy refCodesRepositoy;

		public List<RefCodes> getAllRefCodes() {
			return refCodesRepositoy.findAll();
		}

		public RefCodes getRefCodesById(UUID Id) {
			return refCodesRepositoy.findById(Id).orElse(null);
		}

		public UUID saveRefCodes(RefCodes refcodes) {
			refcodes.setCrtTs(new Timestamp(System.currentTimeMillis()));
			refcodes.setModTs(new Timestamp(System.currentTimeMillis()));
			refcodes.setCodeTypeId(UUID.randomUUID());
			refcodes = refCodesRepositoy.save(refcodes);
			return refcodes.getRefCodeId();
		}

		public UUID updateRefCodes(RefCodes refcodes,UUID Id) {
			refcodes.setModTs(new Timestamp(System.currentTimeMillis()));
			refCodesRepositoy.save(refcodes);
			return refcodes.getRefCodeId();
		}

		public void deleteRefCodes(UUID Id) {
			refCodesRepositoy.deleteById(Id);
		}
}
