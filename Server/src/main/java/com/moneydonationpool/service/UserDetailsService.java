package com.moneydonationpool.service;

import java.util.List;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;

public interface UserDetailsService {

	UserDetailsModel getUserDetails(int userId);

	UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity) throws MoneyDonationPoolException;

	UserDetailsEntity PromoteToAdmin(int userID, int userToPromote) throws MoneyDonationPoolException;

}
