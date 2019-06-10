package com.moneydonationpool.service;

import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;

public interface UserDetailsService {

	UserDetailsModel getUserDetails(String authorization);

	UserDetailsEntity PromoteToAdmin(int userID, int userToPromote) throws MoneyDonationPoolException;

	String userTokenRegistery(String accessToken, String emailId) throws MoneyDonationPoolException;

	String userTokenDeRegistery(String accessToken) throws MoneyDonationPoolException;

}
