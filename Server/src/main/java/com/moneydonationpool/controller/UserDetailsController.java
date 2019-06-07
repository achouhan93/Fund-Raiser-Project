package com.moneydonationpool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;
import com.moneydonationpool.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService; 
	
	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/{userId}")
	public UserDetailsModel getUserDetails(@PathVariable int userId) {
		LOGGER.info("getAllActiveCauses service called");
		return userDetailsService.getUserDetails(userId);
	}
	
	@PostMapping("/")
	public UserDetailsEntity registerUser(@RequestHeader String accessToken,@RequestBody UserDetailsEntity userDetailsEntity) throws MoneyDonationPoolException {
		LOGGER.info("registerUser service called");
		return userDetailsService.registerUser(userDetailsEntity);
	}
	
	@PutMapping(value = "/", params = { "userId", "userToPromote" })
	public UserDetailsEntity PromoteToAdmin(@RequestHeader String accessToken,@RequestParam int userId, @RequestParam int userToPromote) throws MoneyDonationPoolException {
		LOGGER.info("PromoteToAdmin service called");
		return userDetailsService.PromoteToAdmin(userId,userToPromote);
	}
	
	@GetMapping("/login")
	public int userTokenRegistery(@RequestHeader String accessToken,@RequestParam String emailId) throws MoneyDonationPoolException {
		LOGGER.info("userTokenRegistery service called");
		return userDetailsService.userTokenRegistery(accessToken,emailId);
	}
	
}
