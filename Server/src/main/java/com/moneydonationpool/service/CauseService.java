package com.moneydonationpool.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.moneydonationpool.entity.CauseEntity;

public interface CauseService {

	List<CauseEntity> getAllActiveCauses();

	CauseEntity getCauseById(int causeId);

	CauseEntity postCause(CauseEntity postCauseDetails);

	CauseEntity updateCause(CauseEntity editCause, int userId);

	ResponseEntity<String> deleteCause(int causeId, int userId);

	

	

}
