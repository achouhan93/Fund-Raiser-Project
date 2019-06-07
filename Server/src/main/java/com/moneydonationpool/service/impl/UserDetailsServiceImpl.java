package com.moneydonationpool.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneydonationpool.dao.UserDetailsDao;
import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.LoginEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.DonationModel;
import com.moneydonationpool.model.UserDetailsModel;
import com.moneydonationpool.service.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	UserDetailsDao userDetailsDao;

	@Override
	public UserDetailsModel getUserDetails(int userId) {
		UserDetailsEntity userDetails = userDetailsDao.getUserDetails(userId);
		List<DonationModel> UserDonations = userDetailsDao.getUserDonations(userId);
		List<CauseEntity> userCause=null;
		if (userDetails.getUserType() != "Admin") {
			userCause = userDetailsDao.getUserCreatedCause(userId);
		}
		
		UserDetailsModel userDetailsModel = new UserDetailsModel();
		userDetailsModel.setUserDonations(UserDonations);
		userDetailsModel.setUserDetails(userDetails);
		userDetailsModel.setUserCauses(userCause);
		LOGGER.info("userDetailsModel:" + userDetailsModel);
		return userDetailsModel;
	}

	@Override
	public UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity) throws MoneyDonationPoolException {
		List<String> allEmailIds = userDetailsDao.getExsistingEmails();
		if (allEmailIds.contains(userDetailsEntity.getEmailId())) {
			throw new MoneyDonationPoolException(com.moneydonationpool.exception.ErrorCodes.USER_ALREADY_EXSIST);
		}
		return userDetailsDao.registerUser(userDetailsEntity);
	}

	@Override
	public UserDetailsEntity PromoteToAdmin(int userID, int userToPromote) throws MoneyDonationPoolException {
		UserDetailsEntity adminUserDetailsEntity = userDetailsDao.getUserDetails(userID);
		if (!adminUserDetailsEntity.getUserType().equalsIgnoreCase("Admin")) {
			throw new MoneyDonationPoolException(com.moneydonationpool.exception.ErrorCodes.USER_HAS_NO_ACCESS);
		}
		UserDetailsEntity userDetailsEntity = userDetailsDao.getUserDetails(userToPromote);
		userDetailsEntity.setUserType("Admin");
		return userDetailsDao.PromoteToAdmin(userDetailsEntity);
	}

	@Override
	public int userTokenRegistery(String accessToken, String emailId) throws MoneyDonationPoolException {
		int userId = userDetailsDao.getUserIdByEmailId(emailId);
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setAccessToken(accessToken);
		loginEntity.setUserId(userId);
		
		String loginStatus = userDetailsDao.userTokenRegistery(loginEntity);
		if(!loginStatus.equalsIgnoreCase("success"))
		{
			throw new MoneyDonationPoolException(com.moneydonationpool.exception.ErrorCodes.SOMETHING_WENT_WRONG);
		}
		return userId;
		
	}

}
