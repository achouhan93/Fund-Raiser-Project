package com.moneydonationpool.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moneydonationpool.dao.UserDetailsDao;
import com.moneydonationpool.entity.CauseEntity;
import com.moneydonationpool.entity.UserDetailsEntity;
import com.moneydonationpool.model.DonationModel;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao  {
	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserDetailsEntity getUserDetails(int userId,String emailId) {
		Session session = sessionFactory.getCurrentSession();
		List<UserDetailsEntity> userDetailsEntity = session.createQuery("from UserDetailsEntity u where u.isActive=true and userId="+userId).list();
		return userDetailsEntity.get(0);
	}
	
	@Override
	public List<String> getExsistingEmails() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select u.emailId from UserDetailsEntity u where u.isActive=true").list();
	}

	@Override
	public UserDetailsEntity registerUser(UserDetailsEntity userDetailsEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userDetailsEntity);
		return userDetailsEntity;
	}

	@Override
	public UserDetailsEntity PromoteToAdmin(UserDetailsEntity userDetailsEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userDetailsEntity);
		return userDetailsEntity;
	}

	@Override
	public List<DonationModel> getUserDonations(int userId) {
		Session session = sessionFactory.getCurrentSession();
		List<DonationModel> userDonation = session.createQuery("select c.causeTitle,d.amountDonated from DonationEntity d join CauseEntity c on c.causeId = d.causeId where d.donatedBy =1").list();
		return userDonation;
	}

	@Override
	public List<CauseEntity> getUserCreatedCause(int userId) {
		Session session = sessionFactory.getCurrentSession();
		List<CauseEntity> userCauses = session.createQuery("from CauseEntity c where c.createdBy =1").list();
		return userCauses;
	}
	
	
	
	
}
