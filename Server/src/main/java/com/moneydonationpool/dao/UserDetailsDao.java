package com.moneydonationpool.dao;

import java.util.List;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.DonationEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.model.DonationModel;
import com.moneydonationpool.model.UserDetailsModel;

public interface UserDetailsDao {

	UserDetailsEntity getUserDetails(int userId, String emailId);

	List<String> getExsistingEmails();

	UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity);

	UserDetailsEntity PromoteToAdmin(UserDetailsEntity userDetailsEntity);

	List<DonationModel> getUserDonations(int userId);

	List<CauseEntity> getUserCreatedCause(int userId);


}
