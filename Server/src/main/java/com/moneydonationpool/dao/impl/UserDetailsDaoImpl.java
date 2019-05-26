package com.moneydonationpool.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moneydonationpool.dao.UserDetailsDao;
import com.moneydonationpool.entity.UserDetailsEntity;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao  {
	SessionFactory sessionFactory;
	
	@Override
	public UserDetailsEntity getUserDetails(int userId) {
		Session session = sessionFactory.getCurrentSession();
		List<UserDetailsEntity> userDetailsEntity = session.createQuery("from UserDetailsEntity u where u.isActive=true and userId="+userId).list();
		return userDetailsEntity.get(0);
	}
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
