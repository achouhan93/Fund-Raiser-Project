package com.moneydonationpool.dao;

import java.util.List;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.LoginEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.model.DonationModel;

public interface UserDetailsDao {

	UserDetailsEntity getUserDetails(int userId);

	List<String> getExsistingEmails();

	UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity);

	UserDetailsEntity PromoteToAdmin(UserDetailsEntity userDetailsEntity);

	List<DonationModel> getUserDonations(int userId);

	List<CauseEntity> getUserCreatedCause(int userId);

	public int getUserIdByEmailId(String emailId);


	String userTokenRegistery(LoginEntity loginEntity);


}
