package com.moneydonationpool.service;

import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;

public interface UserDetailsService {

	UserDetailsModel getUserDetails(int userId);

	UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity) throws MoneyDonationPoolException;

	UserDetailsEntity PromoteToAdmin(int userID, int userToPromote) throws MoneyDonationPoolException;

	int userTokenRegistery(String accessToken, String emailId) throws MoneyDonationPoolException;

}
