package com.moneydonationpool.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneydonationpool.dao.UserDetailsDao;
import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.DonationEntity;
import com.moneydonationpool.entity.LoginEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.UserDetailsModel;
import com.moneydonationpool.service.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	UserDetailsDao userDetailsDao;

	@Override
	public UserDetailsModel getUserDetails(String accessToken) {
		LoginEntity userLoginEntity = userDetailsDao.checkUserSessionDetails(accessToken);
		UserDetailsEntity userDetails = userDetailsDao.getUserDetails(userLoginEntity.getUserId());
		List<DonationEntity> UserDonations = userDetailsDao.getUserDonations(userLoginEntity.getUserId());
		List<CauseEntity> userCause=null;
		if (userDetails.getUserType() != "Admin") {
			userCause = userDetailsDao.getUserCreatedCause(userLoginEntity.getUserId());
		}
		
		UserDetailsModel userDetailsModel = new UserDetailsModel();
		userDetailsModel.setUserDonations(UserDonations);
		userDetailsModel.setUserDetails(userDetails);
		userDetailsModel.setUserCauses(userCause);
		LOGGER.info("userDetailsModel:" + userDetailsModel);
		return userDetailsModel;
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

	@SuppressWarnings("unused")
	@Override
	public String userTokenRegistery(String accessToken, String emailId) throws MoneyDonationPoolException {
		List<UserDetailsEntity> isUserExsist = userDetailsDao.getUserIdByEmailId(emailId);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		if(isUserExsist.isEmpty())
		{
			UserDetailsEntity userDetailsEntity = new  UserDetailsEntity();
			userDetailsEntity.setActive(true);
			userDetailsEntity.setCreationDate(time);
			userDetailsEntity.setEmailId(emailId);
			userDetailsEntity.setModifiedDate(time);
			userDetailsEntity.setUserType("user");
			userDetailsDao.registerUser(userDetailsEntity);
		}
		List<UserDetailsEntity> newUserDetails = userDetailsDao.getUserIdByEmailId(emailId);
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setAccessToken(accessToken);
		loginEntity.setUserId(newUserDetails.get(0).getUserId());
		
		String loginStatus = userDetailsDao.userTokenRegistery(loginEntity);
		if(!loginStatus.equalsIgnoreCase("success"))
		{
			throw new MoneyDonationPoolException(com.moneydonationpool.exception.ErrorCodes.SOMETHING_WENT_WRONG);
		}
		return "Success";
		
	}

	@Override
	public String userTokenDeRegistery(String accessToken) throws MoneyDonationPoolException {
		LoginEntity LoginEntityDetails = userDetailsDao.checkUserSessionDetails(accessToken);
		if(LoginEntityDetails.equals(null))
		{
			throw new MoneyDonationPoolException(com.moneydonationpool.exception.ErrorCodes.SOMETHING_WENT_WRONG);
		
		}
		String tokenStatus = userDetailsDao.userTokenDeRegistery(LoginEntityDetails);
		return tokenStatus;
		
	}

}
