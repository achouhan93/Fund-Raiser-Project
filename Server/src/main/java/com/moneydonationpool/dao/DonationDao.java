package com.moneydonationpool.dao;

import com.moneydonationpool.entity.DonationEntity;
import com.moneydonationpool.model.DonationModel;

public interface DonationDao {

	DonationEntity postDonationDetails(DonationEntity donationDetails);

}
