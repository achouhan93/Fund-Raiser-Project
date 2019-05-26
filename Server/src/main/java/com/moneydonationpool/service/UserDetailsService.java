package com.moneydonationpool.service;

import java.util.List;

import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.UserDetailsEntity;

public interface UserDetailsService {

	UserDetailsEntity getUserDetails(int userId);

}
