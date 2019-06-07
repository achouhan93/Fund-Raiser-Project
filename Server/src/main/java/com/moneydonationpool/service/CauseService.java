package com.moneydonationpool.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;

public interface CauseService {

	List<CauseEntity> getAllActiveCauses();

	CauseEntity getCauseById(int causeId);

	CauseEntity postCause(CauseEntity postCauseDetails, int userId) throws MoneyDonationPoolException;

	CauseEntity updateCause(CauseEntity editCause, int userId) throws MoneyDonationPoolException;

	ResponseEntity<String> deacticateCause(int causeId, int userId) throws MoneyDonationPoolException;

	List<CauseEntity> SearchCause(String searchString, Integer categoryId);

	

	

}
