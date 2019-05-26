package com.moneydonationpool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService; 
	
	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/getUserDetails")
	public UserDetailsEntity getUserDetails(@RequestParam int userId) {
		LOGGER.info("getAllActiveCauses service called");
		return userDetailsService.getUserDetails(userId);
	}
	
	/*@postMapping("/registerUser")
	public UserDetailsEntity getUserDetails(@RequestParam int userId) {
		LOGGER.info("getAllActiveCauses service called");
		return userDetailsService.getUserDetails(userId);
	}*/

}
