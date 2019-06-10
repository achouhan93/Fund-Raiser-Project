package com.moneydonationpool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;
import com.moneydonationpool.service.UserDetailsService;
@CrossOrigin
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService; 
	
	private static final Logger LOGGER = LogManager.getLogger();

	
	@GetMapping("/")
	public UserDetailsModel getUserDetails(@RequestHeader String accessToken) {
		LOGGER.info("getAllActiveCauses service called");
		return userDetailsService.getUserDetails(accessToken);
	}

	
	@PutMapping(value = "/", params = { "userId", "userToPromote" })
	public UserDetailsEntity PromoteToAdmin(@RequestHeader String accessToken,@RequestParam int userId, @RequestParam int userToPromote) throws MoneyDonationPoolException {
		LOGGER.info("PromoteToAdmin service called");
		return userDetailsService.PromoteToAdmin(userId,userToPromote);
	}
	
	@PostMapping("/login")
	public String userTokenRegistery(@RequestHeader String accessToken,@RequestParam String emailId) throws MoneyDonationPoolException {
		LOGGER.info("userTokenRegistery service called");
		return userDetailsService.userTokenRegistery(accessToken,emailId);
	}	
	
	@DeleteMapping("/logout")
	public String userTokenDeRegistery(@RequestHeader String accessToken) throws MoneyDonationPoolException {
		LOGGER.info("userTokenDeRegistery service called");
		return userDetailsService.userTokenDeRegistery(accessToken);
	}
	
}
