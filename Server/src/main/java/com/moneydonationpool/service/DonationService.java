package com.moneydonationpool.service;

import com.moneydonationpool.entity.DonationEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;

public interface DonationService {

	public DonationEntity postDonationDetails(String accessToken, DonationEntity donationDetails) throws MoneyDonationPoolException;
}
