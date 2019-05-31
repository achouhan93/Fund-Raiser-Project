package com.moneydonationpool.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.moneydonationpool.dao.CauseDao;
import com.moneydonationpool.entity.CauseEntity;

@Repository(value = "CauseDao")
public class CauseDaoImpl implements CauseDao {
	SessionFactory sessionFactory;

	@Override
	public List<CauseEntity> getAllActiveCauses() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from CauseEntity c where c.isActive=true").list();
	}
	
	@Override
	public CauseEntity getCauseById(int causeId) {
		Session session = sessionFactory.getCurrentSession();
		List<CauseEntity> selectedCauseEntity = session.createQuery("from CauseEntity c where c.isActive=true and c.causeId="+causeId).list();
		return selectedCauseEntity.get(0);
	}

	@Override
	public CauseEntity postCause(CauseEntity postCauseDetails) {
		Session session = sessionFactory.getCurrentSession();
		session.save(postCauseDetails);
		return postCauseDetails;
	}
	
	@Override
	public CauseEntity updateCause(CauseEntity updateCause) {
		Session session = sessionFactory.getCurrentSession();
		CauseEntity updateEventById = session.get(CauseEntity.class, updateCause.getCauseId());
		session.update(updateEventById);
		return updateEventById;
	}
	
	@Override
	public ResponseEntity<String> deleteCause(int causeId) {
		Session session = sessionFactory.getCurrentSession();
		CauseEntity deleteCause = session.get(CauseEntity.class, causeId);
		//UnimitraUtility.nullCheckForEntity(deleteEventById, ErrorCodes.EVENT_NOT_PRESENT_FOR_EVENTID);

		deleteCause.setActive(false);
		session.update(deleteCause);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
