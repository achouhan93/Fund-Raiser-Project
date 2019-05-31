package com.moneydonationpool.service;

import com.moneydonationpool.entity.DonationEntity;
import com.moneydonationpool.exception.MoneyDonationPoolException;
import com.moneydonationpool.model.DonationModel;

public interface DonationService {

	public DonationEntity postDonationDetails(DonationEntity donationDetails) throws MoneyDonationPoolException;
}
