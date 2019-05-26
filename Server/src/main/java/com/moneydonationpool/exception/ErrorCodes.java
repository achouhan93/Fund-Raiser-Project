package com.moneydonationpool.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

	public static final String USER_HAS_NO_ACCESS = "MDP001 " + HttpStatus.UNAUTHORIZED.value()
			+ ": User does not have access to do the mentioned change";
}