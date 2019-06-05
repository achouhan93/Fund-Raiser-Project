package com.moneydonationpool.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.moneydonationpool.entity.CauseEntity;

public interface CauseDao {

	List<CauseEntity> getAllActiveCauses();

	CauseEntity getCauseById(int causeId);

	CauseEntity postCause(CauseEntity postCauseDetails);
	
	CauseEntity updateCause(CauseEntity updateCause);

	ResponseEntity<String> deleteCause(int causeId);

	List<CauseEntity> searchCause(String causeName, Integer categoryId);

	

}
