package com.moneydonationpool.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.moneydonationpool.dao.CauseDao;
import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.service.CauseService;

@Service
@Transactional
public class CauseServiceImpl implements CauseService {

	@Autowired
	CauseDao causeDao;

	@Override
	public List<CauseEntity> getAllActiveCauses() {
		List<CauseEntity> AllCauseList = causeDao.getAllActiveCauses();
		return AllCauseList;
	}

	@Override
	public CauseEntity getCauseById(int causeId) {
		return causeDao.getCauseById(causeId);
	}

	@Override
	public CauseEntity postCause(CauseEntity postCauseDetails) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		postCauseDetails.setCreationDate(time);
		return causeDao.postCause(postCauseDetails);
	}

	@Override
	public CauseEntity updateCause(CauseEntity updateCauseDetails, int userId) {

		CauseEntity originalCauseDetails = causeDao.getCauseById(updateCauseDetails.getCauseId());

		if (originalCauseDetails.getCreatedBy() != userId) {
			// custome exception write
			// throw new UnimitraException(ErrorCodes.USER_IS_NOT_AUTHORISED);
			return null;
		}
		else {
		originalCauseDetails.setCategoryId(updateCauseDetails.getCategoryId());
		originalCauseDetails.setCauseExpirationDate(updateCauseDetails.getCauseExpirationDate());
		originalCauseDetails.setCauseTargetAmt(updateCauseDetails.getCauseTargetAmt());
		originalCauseDetails.setCollectedAmt(updateCauseDetails.getCollectedAmt());
		originalCauseDetails.setDescription(updateCauseDetails.getDescription());
		originalCauseDetails.setActive(updateCauseDetails.isActive());
		originalCauseDetails.setCauseTitle(updateCauseDetails.getCauseTitle());
		}
		
		causeDao.updateCause(originalCauseDetails);
		return originalCauseDetails;
	}

	@Override
	public ResponseEntity<String> deleteCause(int causeId, int userId) {
		CauseEntity causeDetails = causeDao.getCauseById(causeId);
		if(causeDetails.getCreatedBy() != userId)
		{
			// custome exception write
			// throw new UnimitraException(ErrorCodes.USER_IS_NOT_AUTHORISED);
		}
		causeDao.deleteCause(causeId);
		return null;
	}

}
