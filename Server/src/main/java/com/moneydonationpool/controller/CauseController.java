package com.moneydonationpool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.service.CauseService;

@RestController
@RequestMapping("/cause")
public class CauseController {
	
	@Autowired
	CauseService causeService;

	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/getAllActiveCauses")
	public List<CauseEntity> getAllActiveCauses() {
		LOGGER.info("getAllActiveCauses servvice called");
		return causeService.getAllActiveCauses();
	}
	
	@GetMapping("/getCauseById")
	public CauseEntity getCauseById(@RequestParam int causeId) {
		LOGGER.info("getCausesById");
		return causeService.getCauseById(causeId);
	}
	
	@GetMapping("/SearchCause")
	public List<CauseEntity> SearchCause(@RequestParam(required = false) String causeName,@RequestParam(required = false) Integer categoryId ) {
		LOGGER.info("SearchCause");
		return causeService.SearchCause(causeName,categoryId);
	}
	
	@PostMapping("/postCause")
	public CauseEntity postCause(@RequestBody CauseEntity postCauseDetails,@RequestParam int userId) throws MoneyDonationPoolException {
		LOGGER.info("psotCause");
		return causeService.postCause(postCauseDetails,userId);
	}
	
	@PostMapping("/updateCause")
	public CauseEntity updateCause(@RequestBody CauseEntity updateCause, @RequestParam int userId) throws MoneyDonationPoolException {
		return causeService.updateCause(updateCause,userId);
	}

	@DeleteMapping("/deleteCause")
	public ResponseEntity<String> deleteCause(@RequestParam int causeId, @RequestParam int userId) throws MoneyDonationPoolException {
		return causeService.deleteCause(causeId, userId);

	}

}
