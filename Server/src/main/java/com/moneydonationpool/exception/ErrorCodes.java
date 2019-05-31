package com.moneydonationpool.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

	public static final String USER_HAS_NO_ACCESS = "MDP001 " + HttpStatus.UNAUTHORIZED.value()
			+ ": User does not have access to do the mentioned change";
	
	public static final String USER_ALREADY_EXSIST = "MDP002 " + HttpStatus.ALREADY_REPORTED.value()
	+ ": User already exsist in the system";
	
	public static final String TARGET_AMOUNT_EXCEEDS = "MDP003 " + HttpStatus.NOT_ACCEPTABLE.value()
	+ ": selected Donate amount is exceeds the remaining target donation amount";
}