package com.moneydonationpool.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneydonationpool.dao.UserDetailsDao;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.service.UserDetailsService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Override
	public UserDetailsEntity getUserDetails(int userId) {
		return userDetailsDao.getUserDetails(userId);
	}
	
	

}
